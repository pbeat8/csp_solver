package problems;

import java.util.ArrayList;
import java.util.Arrays;

import constraints.Constraint;
import constraints.allDifferent;
import constraints.eq;
import constraints.equnary;
import constraints.lt;
import constraints.nextto;
import models.Domain;
import models.Variable;

public class EinsteinProblem {
	
	ArrayList<Variable> variables;
	ArrayList<Constraint> constraints;
	
	public EinsteinProblem() {
		generateVariablesAndConstraints();
	}

	public ArrayList<Variable> getVariables() {
		return variables;
	}

	public ArrayList<Constraint> getConstraints() {
		return constraints;
	}
	
	private void generateVariablesAndConstraints() {
		//men: "norwegian", "english", "dane", "german", "swede"
		Variable norwegian=new Variable(generateDomain(), "norwegian");
		Variable english=new Variable(generateDomain(), "english");
		Variable dane=new Variable(generateDomain(), "dane");
		Variable german=new Variable(generateDomain(), "german");
		Variable swede=new Variable(generateDomain(), "swede");
		//colors: "red", "green", "white", "yellow", "blue"
		Variable red=new Variable(generateDomain(), "red");
		Variable green=new Variable(generateDomain(), "green");
		Variable white=new Variable(generateDomain(), "white");
		Variable yellow=new Variable(generateDomain(), "yellow");
		Variable blue=new Variable(generateDomain(), "blue");
		//tobaccos: "light", "cigar", "pipe", "unfiltered", "menthol"
		Variable light=new Variable(generateDomain(), "light");
		Variable cigar=new Variable(generateDomain(), "cigar");
		Variable pipe=new Variable(generateDomain(), "pipe");
		Variable unfiltered=new Variable(generateDomain(), "unfiltered");
		Variable menthol=new Variable(generateDomain(), "menthol");
		//drinks: "tea", "milk", "water", "beer", "coffee"
		Variable tea=new Variable(generateDomain(), "tea");
		Variable milk=new Variable(generateDomain(), "milk");
		Variable water=new Variable(generateDomain(), "water");
		Variable beer=new Variable(generateDomain(), "beer");
		Variable coffee=new Variable(generateDomain(), "coffee");
		//pets: "fish", "cat", "bird", "dog", "horse"
		Variable fish=new Variable(generateDomain(), "fish");
		Variable cat=new Variable(generateDomain(), "cat");
		Variable bird=new Variable(generateDomain(), "bird");
		Variable dog=new Variable(generateDomain(), "dog");
		Variable horse=new Variable(generateDomain(), "horse");
		
		variables= new ArrayList<Variable>(Arrays.asList(norwegian, english, dane, german, swede,
														red, green, white, yellow, blue,
														light, cigar, pipe, unfiltered, menthol,
														tea, milk, water, beer, coffee,
														fish, cat, bird, dog, horse));
		
		constraints=new ArrayList<Constraint>();
		constraints.addAll((new allDifferent(new ArrayList<Variable>(Arrays.asList(norwegian, english, dane, german, swede))).toneq()));
		constraints.addAll((new allDifferent(new ArrayList<Variable>(Arrays.asList(red, green, white, yellow, blue))).toneq()));
		constraints.addAll((new allDifferent(new ArrayList<Variable>(Arrays.asList(light, cigar, pipe, unfiltered, menthol))).toneq()));
		constraints.addAll((new allDifferent(new ArrayList<Variable>(Arrays.asList(tea, milk, water, beer, coffee))).toneq()));
		constraints.addAll((new allDifferent(new ArrayList<Variable>(Arrays.asList(fish, cat, bird, dog, horse))).toneq()));
		constraints.add(new equnary(norwegian, 1)); //Norweg zamieszkuje pierwszy dom
		constraints.add(new eq(english, red));//Anglik mieszka w czerwonym domu.
		constraints.add(new lt(green, white));//Zielony dom znajduje siê bezpoœrednio po lewej stronie domu bia³ego.
		constraints.add(new eq(dane, tea));//Duñczyk pija herbatkê.
		constraints.add(new nextto(light, cat));//Palacz papierosów light mieszka obok hodowcy kotów.
		constraints.add(new eq(yellow, cigar));//Mieszkaniec ¿ó³tego domu pali cygara.
		constraints.add(new eq(german, pipe));//Niemiec pali fajkê.
		constraints.add(new equnary(milk, 3));//Mieszkaniec œrodkowego domu pija mleko.
		constraints.add(new nextto(light, water));//Palacz papierosów light ma s¹siada, który pija wodê.
		constraints.add(new eq(unfiltered, bird));//Palacz papierosów bez filtra hoduje ptaki.
		constraints.add(new eq(swede, dog));//Szwed hoduje psy.
		constraints.add(new nextto(norwegian, blue));//Norweg mieszka obok niebieskiego domu.
		constraints.add(new nextto(horse, yellow));//Hodowca koni mieszka obok ¿ó³tego domu.
		constraints.add(new eq(menthol, beer));//Palacz mentolowych pija piwo.
		constraints.add(new eq(green, coffee));//W zielonym domu pija siê kawê
	}
	
	private Domain generateDomain() {
		ArrayList<Integer> domain=new ArrayList<Integer>();
		for(int c=1; c<=5; c++) domain.add(Integer.valueOf(c));
		return new Domain(domain);
	}
}
