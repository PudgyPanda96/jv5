export class User {
    firstName: string;
    lastName: string;
    alias: string;
    email: string;
    country: string;
    state: string;
    city: string;
    password: string;

    getFirstName() {
    	return this.firstName;
    }

    setFirstName(firstName) {
    	this.firstName = firstName;
    }

    getLastName() {
    	return this.lastName;
    }

    setLastName(lastName) {
    	this.lastName = lastName;
    }

    getAlias() {
    	return this.alias;
    }

    setAlias(alias) {
    	this.alias = alias;
    }

    getEmail() {
    	return this.email;
    }

    setEmail(email) {
    	this.email = email;
    }

    getCountry() {
    	return this.country;
    }

    setCountry(country) {
    	this.country = country;
    }

    getState() {
    	return this.state;
    }

    setState(state) {
    	this.state = state;
    }

    getCity() {
    	return this.city;
    }

    setCity(city) {
    	this.city = city;
    }

    getPassword() {
    	return this.password;
    }

    setPassword(password) {
    	this.password = password;
    }

}