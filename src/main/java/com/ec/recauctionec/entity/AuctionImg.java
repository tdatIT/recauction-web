package com.ec.recauctionec.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "auction_img")
public class AuctionImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long imageId;

    @Column(name = "image_file")
    private String imageFile;

    @ManyToOne
    @JoinColumn(name = "auction_session_id")
    private AuctionSession auction;

}
