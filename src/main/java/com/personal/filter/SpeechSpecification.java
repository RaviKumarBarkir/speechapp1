package com.personal.filter;

import com.personal.entity.Speech;
import com.personal.entity.Speech_;
import com.personal.model.SpeechSearch;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpeechSpecification {


    public static Specification<Speech> filterBySpeechId(String Id) {
        if (null != Id && !Id.toString().isEmpty())
            return (root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("id"),"%"+ Id);
            };
        return null;
    }
    public static Specification<Speech> filterByBody(String body) {
        if (null != body && !body.toString().isEmpty())
            return (root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("body"),"%"+ body+"%");
            };
        return null;
    }

    public static Specification<Speech> filterByAuthor(String author) {
        if (null != author && !author.toString().isEmpty())
            return (root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("author"),"%"+ author+"%");
            };
        return null;
    }

    public static Specification<Speech> filterBySubject(String subject) {
        if (null != subject && !subject.toString().isEmpty())
            return (root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("subject"),"%"+ subject+"%");
            };
        return null;
    }

    public static Specification<Speech> filterBycratedDateRange(LocalDate sartdate,LocalDate enddate) {
        if (null == enddate && null != sartdate )
            return (root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("createdDate"), sartdate.toString());
            };
        else if (null != sartdate )
            return (root, query, criteriaBuilder) -> {
                return criteriaBuilder.between(root.get("createdDate"),sartdate.toString(),enddate.toString());
            };
        return null;
    }

    private static void addSpecificationIfNotNull(List<Specification<Speech>> specs, Specification<Speech> spec){
        if(spec != null){
            specs.add(spec);
        }
    }

    public static Specification<Speech> filterpredicatesBySpeechSearch(SpeechSearch request) {
        List<Specification<Speech>> specifications = filterpredicates(request);
          return specifications.stream().reduce((Spec1, Spec2) ->
                  Spec1.and(Spec2)).get();
    }

    public static List<Specification<Speech>>  filterpredicates(SpeechSearch request) {
        List<Specification<Speech>> specifications = new ArrayList<>();
                addSpecificationIfNotNull(specifications,filterBySpeechId(request.getSpeechid()));
                addSpecificationIfNotNull(specifications,filterBySubject(request.getSubject()));
                addSpecificationIfNotNull(specifications,filterByAuthor(request.getAuthor()));
                addSpecificationIfNotNull(specifications,filterByBody(request.getBody()));
                addSpecificationIfNotNull(specifications,filterBycratedDateRange(request.getStartDateRange(),request.getEndDateRange()));
            return specifications;

    }
}