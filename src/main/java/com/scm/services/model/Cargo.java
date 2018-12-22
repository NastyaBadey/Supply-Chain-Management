package com.scm.services.model;

import javax.persistence.*;

@Entity
public class Cargo {
    private Integer cargoId;
    private String cargoName;
    private Double cargoLength;
    private Double cargoWidth;
    private Double cargoHeight;
    private Double cargoWeight;
    private Byte cargoDangerous;
    private Byte cargoFragile;

    @Id
    @Column(name = "cargo_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }

    @Basic
    @Column(name = "cargo_name", nullable = false, length = 50)
    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    @Basic
    @Column(name = "cargo_length", precision = 2)
    public Double getCargoLength() {
        return cargoLength;
    }

    public void setCargoLength(Double cargoLength) {
        this.cargoLength = cargoLength;
    }

    @Basic
    @Column(name = "cargo_width", precision = 2)
    public Double getCargoWidth() {
        return cargoWidth;
    }

    public void setCargoWidth(Double cargoWidth) {
        this.cargoWidth = cargoWidth;
    }

    @Basic
    @Column(name = "cargo_height", precision = 2)
    public Double getCargoHeight() {
        return cargoHeight;
    }

    public void setCargoHeight(Double cargoHeight) {
        this.cargoHeight = cargoHeight;
    }

    @Basic
    @Column(name = "cargo_weight", precision = 2)
    public Double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(Double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    @Basic
    @Column(name = "cargo_dangerous")
    public Byte getCargoDangerous() {
        return cargoDangerous;
    }

    public void setCargoDangerous(Byte cargoDangerous) {
        this.cargoDangerous = cargoDangerous;
    }

    @Basic
    @Column(name = "cargo_fragile")
    public Byte getCargoFragile() {
        return cargoFragile;
    }

    public void setCargoFragile(Byte cargoFragile) {
        this.cargoFragile = cargoFragile;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "cargoId=" + cargoId +
                ", cargoName='" + cargoName + '\'' +
                ", cargoLength=" + cargoLength +
                ", cargoWidth=" + cargoWidth +
                ", cargoHeight=" + cargoHeight +
                ", cargoWeight=" + cargoWeight +
                ", cargoDangerous=" + cargoDangerous +
                ", cargoFragile=" + cargoFragile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cargo cargo = (Cargo) o;

        if (cargoId != null ? !cargoId.equals(cargo.cargoId) : cargo.cargoId != null) return false;
        if (cargoName != null ? !cargoName.equals(cargo.cargoName) : cargo.cargoName != null) return false;
        if (cargoLength != null ? !cargoLength.equals(cargo.cargoLength) : cargo.cargoLength != null) return false;
        if (cargoWidth != null ? !cargoWidth.equals(cargo.cargoWidth) : cargo.cargoWidth != null) return false;
        if (cargoHeight != null ? !cargoHeight.equals(cargo.cargoHeight) : cargo.cargoHeight != null) return false;
        if (cargoWeight != null ? !cargoWeight.equals(cargo.cargoWeight) : cargo.cargoWeight != null) return false;
        if (cargoDangerous != null ? !cargoDangerous.equals(cargo.cargoDangerous) : cargo.cargoDangerous != null)
            return false;
        if (cargoFragile != null ? !cargoFragile.equals(cargo.cargoFragile) : cargo.cargoFragile != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cargoId != null ? cargoId.hashCode() : 0;
        result = 31 * result + (cargoName != null ? cargoName.hashCode() : 0);
        result = 31 * result + (cargoLength != null ? cargoLength.hashCode() : 0);
        result = 31 * result + (cargoWidth != null ? cargoWidth.hashCode() : 0);
        result = 31 * result + (cargoHeight != null ? cargoHeight.hashCode() : 0);
        result = 31 * result + (cargoWeight != null ? cargoWeight.hashCode() : 0);
        result = 31 * result + (cargoDangerous != null ? cargoDangerous.hashCode() : 0);
        result = 31 * result + (cargoFragile != null ? cargoFragile.hashCode() : 0);
        return result;
    }
}
