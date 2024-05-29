package br.com.tomaz.api_gateway.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class BookVO extends RepresentationModel<BookVO> implements Serializable {

    @JsonProperty("id")
    private Long key;

    private String autor;

    @JsonProperty("launch_date")
    private Date launchDate;

    private BigDecimal price;

    private String title;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        autor = autor;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookVO bookVO)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(key, bookVO.key) && Objects.equals(autor, bookVO.autor) && Objects.equals(launchDate, bookVO.launchDate) && Objects.equals(price, bookVO.price) && Objects.equals(title, bookVO.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, autor, launchDate, price, title);
    }
}
