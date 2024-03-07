package br.com.nthing.item;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExerciseItemRepository implements PanacheRepository<ExerciseItem> {

    public int updateExerciseItem(ExerciseItem exerciseItem) {
        return update("UPDATE ExerciseItem e SET e.seriesNumber = :seriesNumber, e.measurementType = :measurementType, e.rest = :rest, e.concluded = :concluded, e.note = :note WHERE e.idSequence = :idSequence",
                Parameters.with("seriesNumber", exerciseItem.getSeriesNumber())
                        .and("measurementType", exerciseItem.getMeasurementType())
                        .and("rest", exerciseItem.getRest())
                        .and("concluded", exerciseItem.getConcluded())
                        .and("note", exerciseItem.getNote())
                        .and("idSequence", exerciseItem.getIdSequence()));
    }
}
