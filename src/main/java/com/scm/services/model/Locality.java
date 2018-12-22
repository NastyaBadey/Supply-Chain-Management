package com.scm.services.model;

import javax.persistence.*;

@Entity
public class Locality {
    private Integer localityId;
    private String localityName;
    private String country;

    @Id
    @Column(name = "locality_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getLocalityId() {
        return localityId;
    }

    public void setLocalityId(Integer localityId) {
        this.localityId = localityId;
    }

    @Basic
    @Column(name = "locality_name", nullable = false, length = 50)
    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    @Basic
    @Column(name = "country", nullable = false, length = 30)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "Locality{" +
                "localityId=" + localityId +
                ", localityName='" + localityName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locality locality = (Locality) o;

        if (localityId != null ? !localityId.equals(locality.localityId) : locality.localityId != null) return false;
        if (localityName != null ? !localityName.equals(locality.localityName) : locality.localityName != null)
            return false;
        if (country != null ? !country.equals(locality.country) : locality.country != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = localityId != null ? localityId.hashCode() : 0;
        result = 31 * result + (localityName != null ? localityName.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
