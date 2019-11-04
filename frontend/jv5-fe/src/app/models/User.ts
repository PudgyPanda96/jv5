export class User {
    userId: any;
    firstName: string;
    lastName: string;
    alias: string;
    email: string;
    country: string;
    state: string;
    city: string;
    password: string;

    public getUserId() {
        return this.userId;
    }

    public setUserId(userId) {
        this.userId = userId;
    }

    public getFirstName() {
        return this.firstName;
    }

    public setFirstName(firstName) {
        this.firstName = firstName;
    }

    public getLastName() {
        return this.lastName;
    }

    public setLastName(lastName) {
        this.lastName = lastName;
    }

    public getAlias() {
        return this.alias;
    }

    public setAlias(alias) {
        this.alias = alias;
    }

    public getEmail() {
        return this.email;
    }

    public setEmail(email) {
        this.email = email;
    }

    public getCountry() {
        return this.country;
    }

    public setCountry(country) {
        this.country = country;
    }

    public getState() {
        return this.state;
    }

    public setState(state) {
        this.state = state;
    }

    public getCity() {
        return this.city;
    }

    public setCity(city) {
        this.city = city;
    }

    public getPassword() {
        return this.password;
    }

    public setPassword(password) {
        this.password = password;
    }

}