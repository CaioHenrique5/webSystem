package com.example.team.exampleproject3.model;



import javax.persistence.*;
import java.util.Set;

/**
 * Model for table: ROLE.
 */
@Entity(name = "role")
public class Role {
    /**
     * Role ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    /**
     * Name.
     */
    @Column(name = "name")
    private String name;

    /**
     * Description.
     */
    @Column(name = "description")
    private String description;

    /**
     * Permissions.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission",
            joinColumns = @JoinColumn(name = "idrole"),
            inverseJoinColumns = @JoinColumn(name = "idpermission"))
    private Set<Permission> permissions;

    /**
     * If it is deleted.
     */
    @Column(name = "deleted")
    private boolean deleted;

    /**
     * (non-Javadoc)
     *
     * @see br.edu.ufcg.virtus.core.model.Model#getId()
     */
    public Integer getId() {
        return id;
    }

    /**
     * (non-Javadoc)
     * @see br.edu.ufcg.virtus.core.model.Model#setId(java.io.Serializable)
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets role Name
     * @return Role Name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name
     * @param name Role name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets role Description
     * @return Role Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description
     * @param description Role name
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets role Permissions
     * @return Role Permissions
     */
    public Set<Permission> getPermissions() {
        return permissions;
    }

    /**
     * Sets permissions
     * @param permissions Role name
     */
    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    /**
     * Gets if role is deleted
     * @return isDeleted
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * Sets deleted
     * @param deleted Role name
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    public Role(String name) {
        this.name = name;
    }
    public Role() {
    }

    public String getAuthority() {
        return  this.name;
    }
}
