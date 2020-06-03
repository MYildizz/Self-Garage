package com.yildizmurat.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="manager_information")
public class ManagerInformation extends BaseUserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
