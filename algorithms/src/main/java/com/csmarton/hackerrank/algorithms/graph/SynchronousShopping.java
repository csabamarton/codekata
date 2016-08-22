package com.csmarton.hackerrank.algorithms.graph;

import java.util.*;

public class SynchronousShopping {

	private int numOfShops;
	private int numOfRoads;
	private int numOfAllFishTypes;
	private Set<Integer> gainedFishTypes = new HashSet<Integer>();

	List<Shop> shops = new ArrayList<Shop>();
	List<Road> roads = new ArrayList<Road>();

	Map<Integer, List<Integer>> fishPoSMap = new HashMap<Integer, List<Integer>>();
	List<Integer> uniqueShops = new ArrayList<Integer>();

	List<Road> cat1Route = new ArrayList<Road>();
	List<Road> car2Route = new ArrayList<Road>();

	public static void main(String[] args)
	{
		SynchronousShopping synchronousShopping = new SynchronousShopping();
		synchronousShopping.setInputData();
	}

	private void setInputData()
	{
		String input = "5 5 5\n" + "1 1\n" + "1 2\n" + "1 3\n" + "1 4\n" + "1 5\n" + "1 2 10\n"
				+ "1 3 10\n" + "2 4 10\n" + "3 5 10\n" + "4 5 10";
		Scanner in = new Scanner(input);

		numOfShops = in.nextInt();
		numOfRoads = in.nextInt();
		numOfAllFishTypes = in.nextInt();

		setShops(in);

		in.useDelimiter(" ");
		in.nextLine();
		while (in.hasNextLine()) {

			String s = in.nextLine();
			String[] roadLine = s.split(" ");

			Road road = new Road(Integer.valueOf(roadLine[2]));
			road.setShopA(Integer.valueOf(roadLine[0])-1);
			road.setShopB(Integer.valueOf(roadLine[1])-1);

			roads.add(road);
		}

		gainedFishTypes.addAll(shops.get(0).getFishTypes());

		findNecessaryShops();


		int start = 0;
		Map<Integer, Integer> distanceForUniqueShops = setDistanceForUniqueShops(start);

		int cheapestNecessaryShop = getCheapestNecessaryShop(distanceForUniqueShops);

		//cat1Route.add()
		System.out.print("ok");
	}

	private int getCheapestNecessaryShop(Map<Integer, Integer> distanceForUniqueShops)
	{
		int indexOfcheapest = -1;
		int cheapest = 0;
		for(Integer indexOfShop : uniqueShops) {
			Integer distance = distanceForUniqueShops.get(indexOfShop);

			if((indexOfcheapest ==-1) || distance < cheapest) {
				indexOfcheapest = indexOfShop;
				cheapest = distance;
			}
		}

		return indexOfcheapest;
	}

	private Map<Integer, Integer> setDistanceForUniqueShops(int start)
	{
		setDistancesFrom(start, null, new ArrayList<Road>());

		return shops.get(start).getDistanceMap();
	}

	private void findNecessaryShops()
	{

		for (Map.Entry<Integer, List<Integer>> entry : fishPoSMap.entrySet()) {
			List<Integer> shops = entry.getValue();
			if (!gainedFishTypes.contains(entry.getKey()) && shops.size() == 1 && !uniqueShops.contains(shops.get(0))) {
				uniqueShops.add(shops.get(0));
			}
		}
	}



	private void setFishPrices()
	{
	}

	private void setShops(Scanner in)
	{
		for (int shopCounter = 0; shopCounter < numOfShops; shopCounter++) {
			Shop shop = new Shop();

			int numOfFishTypes = in.nextInt();

			for (int fishTypeCounter = 0; fishTypeCounter < numOfFishTypes; fishTypeCounter++) {
				int fishType = in.nextInt();
				shop.addFishType(fishType);

				addShopToTheFishMap(fishType, shopCounter);
			}

			shops.add(shop);
		}
	}

	private void addShopToTheFishMap(int fishType, int shopCounter)
	{
		List<Integer> shops = fishPoSMap.get(fishType);

		if (shops == null) {
			shops = new ArrayList<Integer>();
		}

		if (!shops.contains(shopCounter)) {
			shops.add(shopCounter);
		}

		fishPoSMap.put(fishType, shops);

	}

	private void setDistancesFrom(Integer baseShopNum, Integer shopANum, List<Road> usedRoads) {
		Shop startShop = shops.get(baseShopNum);
		Shop shopA = null;
		if(shopANum == null) {
			shopA = startShop;
		} else {
			shopA = shops.get(shopANum);
		}

		Map<Integer, Integer> distanceMap = startShop.getDistanceMap();

		boolean hasNewRoad = false;
		List<Road> roadsFromCertainShop = getRoadsFromCertainShop(shops.indexOf(shopA));

		for(Road road : roadsFromCertainShop) {
			if(usedRoads.contains(road)) {
				continue;
			}

			usedRoads.add(road);
			hasNewRoad = true;

			int targetShop = road.getShopB();

			Map<Integer, Way> bestRoutes = startShop.getBestRoutes();

			Way route = bestRoutes.get(targetShop);
			if(route == null) {
				route = new Way();
			}


			int startDist = 0;
			if(shopANum != null) {
				startDist = distanceMap.get(road.getShopA());
			}

			Integer currentShortestDist = distanceMap.get(targetShop);
			if(currentShortestDist == null || currentShortestDist > (road.getDistance() + startDist)) {
				distanceMap.put(targetShop, road.getDistance() + startDist);

				Way wayToShopA = bestRoutes.get(road.shopA);
				if(wayToShopA != null) {
					route = wayToShopA;
				}
				route.addRoadToWay(road);
				bestRoutes.put(targetShop, route);
			}
		}

		if(hasNewRoad) {
			for (Road road : roadsFromCertainShop) {
				setDistancesFrom(baseShopNum, road.getShopB(), usedRoads);
			}
		}
	}

	public List<Road> getRoadsFromCertainShop(int start) {
		List<Road> roadsForStart = new ArrayList<Road>();

		for(Road road : roads) {
			if (road.getShopA() == start || road.getShopB() == start){
				roadsForStart.add(road);
			}
		}

		return roadsForStart;
	}

	private class Shop {
		private List<Road> roads = new ArrayList<Road>();
		private List<Integer> fishTypes = new ArrayList<Integer>();

		private Map<Integer, Way> bestRoutes = new HashMap<Integer, Way>();
		private Map<Integer, Integer> distanceMap = new HashMap<Integer, Integer>();

		public Map<Integer, Way> getBestRoutes()
		{
			return bestRoutes;
		}

		public Map<Integer, Integer> getDistanceMap()
		{
			return distanceMap;
		}

		public void addDistanceToMap(Integer shopNumber, Integer distance)
		{
			distanceMap.put(shopNumber, distance);
		}

		public List<Road> getRoads()
		{
			return roads;
		}

		public void setRoads(List roads)
		{
			this.roads = roads;
		}

		public void addFishType(int fishType)
		{
			if (!fishTypes.contains(fishType)) {
				fishTypes.add(fishType);
			}
		}

		public List<Integer> getFishTypes()
		{
			return fishTypes;
		}
	}

	private class Road {
		private int distance;
		private int shopA;
		private int shopB;

		public Road(int distance)
		{
			this.distance = distance;
		}

		public int getDistance()
		{
			return distance;
		}

		public int getShopA()
		{
			return shopA;
		}

		public void setShopA(int shopA)
		{
			this.shopA = shopA;
		}

		public int getShopB()
		{
			return shopB;
		}

		public void setShopB(int shopB)
		{
			this.shopB = shopB;
		}
	}

	private class Way {
		int sum;
		List<Road> way = new ArrayList<Road>();

		public List<Road> getWay()
		{
			return way;
		}

		public void setWay(List<Road> way)
		{
			this.way = way;
			int sum = 0;

			for (Road road : way) {
				sum = sum + road.getDistance();
			}
		}

		public void addRoadToWay(Road road) {
			way.add(road);

			int distance = road.getDistance();

			if(sum == 0) {
				sum = distance;
			} else {
				sum = sum + distance;
			}

		}

		List<Integer> gainedFishTypes;
	}
}
