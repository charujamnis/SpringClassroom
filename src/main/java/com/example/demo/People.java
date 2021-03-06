package com.example.demo;

import java.util.Iterator;
import java.util.List;

public abstract class People <PersonType extends Person> implements Iterable<PersonType>{

    List<PersonType> personList;

    public People(List<PersonType> personList){
        this.personList=personList;
    }

    public void add(PersonType persontype){
        personList.add(persontype);
    }

    public void remove(PersonType personType){
        if(personList.contains(personType)){
            personList.remove(personType);
        }
    }

    public Integer size(){
        return personList.size();
    }

    public void clear(){
        personList.clear();
    }

    //This method will NOT take an argument of Collection<PersonType>
    //ask if it is right?
    public void addAll(Iterable<PersonType> personTypes){
       for(PersonType p:personTypes){
            personList.add(p);
        }
    }
    public PersonType findById(Long id){

        for(int i=0;i<personList.size();i++) {
            if (personList.get(i).getId()==id) {
                return personList.get(i);
            }
        }
        return null;
    }

    public List<PersonType> findAll(){
        return this.personList;
    }

    public List<PersonType> getPersonList() {
        return personList;
    }

    public void setPersonList(List<PersonType> personList) {
        this.personList = personList;
    }
}
