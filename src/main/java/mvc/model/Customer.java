    package mvc.model;

    import javax.persistence.*;

    @Entity
    @Table(name = "customer")
    public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private int id;
        @Column(name = "address_customer")
        private String address;

        @Column(name="name_customer")
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
