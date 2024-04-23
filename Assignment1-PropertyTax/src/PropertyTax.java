
public class PropertyTax {

    private double actualValue;
    private char propertyType;
    public final double RESIDENTIAL_TAX = 0.821, COMMERCIAL_TAX = 1.78, FARMLAND_TAX = 0.152, MUNICIPAL_TAX_PERCENTAGE = 0.471, REGIONAL_TAX_PERCENTAGE = 0.332, EDUCATION_TAX_PERCENTAGE = 0.197;

    //_____________________________________________________________________
    //constructor
    public PropertyTax(double a, char b){
        actualValue = a;
        propertyType = b;
    }
    
    public PropertyTax(){
        actualValue = 0;
        propertyType = '0';
    }
    
    //_____________________________________________________________________
    //set actual value
    public void setActualValue(double c) {
        actualValue = c;
    }

    //get actual value
    public double getActualValue() {
        return actualValue;
    }

    //calculate assessment value
    public double calculateAssessmentValue() {
        double assessmentValue = actualValue * 0.6;
        return assessmentValue;
    }

    //_____________________________________________________________________
    //set property type
    public void setPropertyType(char d) {
        propertyType = d;
    }

    //get property type
    public char getPropertyType() {
        return propertyType;
    }

    //map property type to property name
    public String mapPropertyName() {
        
        String propertyName = "";
        
        switch (Character.toUpperCase(propertyType)) {
            case 'R':
                propertyName = "Residential";
                break;
            case 'L':
                propertyName = "Farmland";
                break;
            case 'C':
                propertyName = "Commercial";
                break;
        }
        return propertyName;
    }

    //calculate property tax based on property type
    public double calculatePropertyTax() {
        
        double tax = 0;
        double value = calculateAssessmentValue() / 100;
        
        switch (Character.toUpperCase(propertyType)) {
            case 'R':
                tax = value * RESIDENTIAL_TAX;
                break;
            case 'L':
                tax = value * FARMLAND_TAX;
                break;
            case 'C':
                tax = value * COMMERCIAL_TAX;
                break;
        }
        return tax;
    }

    //calculate municipal tax 
    public double calculateMunicipalTax() {
        double municipalTax = calculatePropertyTax() * MUNICIPAL_TAX_PERCENTAGE;
        return municipalTax;
    }

    //calculate regional tax 
    public double calculateRegionalTax() {
        double regionalTax = calculatePropertyTax() * REGIONAL_TAX_PERCENTAGE;
        return regionalTax;
    }

    //calculate education tax 
    public double calculateEducationTax() {
        double educationTax = calculatePropertyTax() * EDUCATION_TAX_PERCENTAGE;
        return educationTax;
    }

    //calculate total tax
    public double calculateTotalTax() {
        
        double totalTax = calculateMunicipalTax() + calculateRegionalTax() + calculateEducationTax();
        return totalTax;
    }

    @Override
    public String toString() {
        return 
                "You own a " + mapPropertyName() + " Property whose Actual Value is $" + (String.format("%.2f", getActualValue()))
                + "\nYour Total Property Taxes based on the Assessment Value of $" + (String.format("%.2f", calculateAssessmentValue())) + " are $" + (String.format("%.2f", calculateTotalTax()))
                + "\n\nTax Breakdown \n\n"
                + "Tax \t              Amount \n"
                + "--------------------------------------------------\n"
                + "Municipal Taxes: \t $" + (String.format("%.1f", calculateMunicipalTax())) + " (" + (String.format("%.2f",(MUNICIPAL_TAX_PERCENTAGE*100))) + "% of the total property tax) \n"
                + "Regional Taxes: \t $" + (String.format("%.1f", calculateRegionalTax())) + " (" + (String.format("%.2f",(REGIONAL_TAX_PERCENTAGE*100))) + "% of the total property tax) \n"
                + "Education Taxes: \t $" + (String.format("%.1f", calculateEducationTax())) + " (" + (String.format("%.2f",(EDUCATION_TAX_PERCENTAGE*100))) + "% of the total property tax)"
                
                ;

        
    }

}
