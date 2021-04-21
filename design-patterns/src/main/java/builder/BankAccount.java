package builder;

public class BankAccount {
    private long accountNumber;
    private String firstName;
    private String lastName;

    public static class Builder {
        private long accountNumber;
        private String firstName;
        private String lastName;

        public Builder(long accountNumber) {
            this.accountNumber = accountNumber;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;

            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;

            return this;
        }

        public BankAccount build() {
            BankAccount bankAccount = new BankAccount();
            bankAccount.accountNumber = this.accountNumber;
            bankAccount.firstName = this.firstName;
            bankAccount.lastName = this.lastName;

            return bankAccount;
        }
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new Builder(213L)
                .firstName("Csaba")
                .lastName("Marton")
                .build();

        System.out.println("Bank account: " + bankAccount.firstName  + " " + bankAccount.lastName + ", AccountNum: " + bankAccount.accountNumber);
    }
}
