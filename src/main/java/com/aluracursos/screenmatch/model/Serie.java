package com.aluracursos.screenmatch.model;

import java.util.Optional;
import java.util.OptionalDouble;

public class Serie {
    private String titulo;
    private Integer totalTemporadas;
    private OptionalDouble evaluacion;
    private String poster;
    private Categoria genero;
    private String actores;
    private String sinopsis;

    public Serie (DatosSerie datosSerie){
        this.titulo = datosSerie.titulo();
        this.totalTemporadas = datosSerie.totalTemporadas();
        this.evaluacion = Optional.ofNullable(datosSerie.evaluacion())
                .filter(evalStr -> !evalStr.equalsIgnoreCase("N/A")) // Filtrar "N/A"
                .map(Double::parseDouble) // Convertir a double si es posible
                .map(OptionalDouble::of) // Envolver en OptionalDouble
                .orElse(OptionalDouble.empty()); // Valor por defecto si no se puede convertir
        this.poster = datosSerie.poster();
        this.genero = Categoria.fromString(datosSerie.genero().split(",") [0]);
        this.actores = datosSerie.actores();
        this.sinopsis =  datosSerie.sinopsis();
    }

    @Override
    public String toString() {
        return  ", genero=" + genero +
                "titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", evaluacion=" + evaluacion +
                ", poster='" + poster + '\'' +
                ", actores='" + actores + '\'' +
                ", sinopsis='" + sinopsis + '\'';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public OptionalDouble getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(OptionalDouble evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
