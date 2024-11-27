package agenda.agenda.model;

import jakarta.persistence.*;

@Entity
@Table(name = "evento")
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String inicio;

    @Column(nullable = false)
    private String fin;

    @Column(name = "color_fondo", nullable = false)
    private String colorFondo;

    @Column(name = "color_borde", nullable = false)
    private String colorBorde;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioModel usuario;

    public EventModel() {
    }

    public EventModel(String titulo, String inicio, String fin, String colorFondo, String colorBorde, UsuarioModel usuario) {
        this.titulo = titulo;
        this.inicio = inicio;
        this.fin = fin;
        this.colorFondo = colorFondo;
        this.colorBorde = colorBorde;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(String colorFondo) {
        this.colorFondo = colorFondo;
    }

    public String getColorBorde() {
        return colorBorde;
    }

    public void setColorBorde(String colorBorde) {
        this.colorBorde = colorBorde;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}
