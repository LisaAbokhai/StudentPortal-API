package com.example.student.model.student;


public enum ProgrammeEnum {
    ACCOUNTANCY("Accountancy / Accounting"),
    ACTUARIAL_SCIENCE("Actuarial Science"),
    ADULT_EDUCATION("Adult Education"),
    ARCHITECTURE("Architecture"),
    BANKING_AND_FINANCE("Banking and Finance"),
    BIOCHEMISTRY("Biochemistry"),
    BIOLOGY("Biology"),
    BIOMEDICAL_ENGINEERING("Biomedical Engineering"),
    BOTANY("Botany"),
    BUILDING("Building"),
    BUSINESS_ADMINISTRATION("Business Administration"),
    BUSINESS_EDUCATION("Business Education"),
    CELL_BIOLOGY_AND_GENETICS("Cell Biology and Genetics"),
    CHEMICAL_ENGINEERING("Chemical Engineering"),
    CHEMISTRY("Chemistry"),
    CHINESE_STUDIES("Chinese Studies"),
    CHRISTIAN_RELIGIOUS_KNOWLEDGE("Christian Religious Knowledge / Studies"),
    CIVIL_ENGINEERING("Civil Engineering"),
    COMPUTER_ENGINEERING("Computer Engineering"),
    COMPUTER_SCIENCE("Computer Science"),
    CREATIVE_ARTS("Creative Arts"),
    DENTISTRY_AND_DENTAL_SURGERY("Dentistry And Dental Surgery"),
    EARLY_CHILDHOOD_EDUCATION("Early Childhood Education"),
    ECONOMICS("Economics"),
    EDUCATION_AND_BIOLOGY("Education and Biology"),
    EDUCATION_AND_CHEMISTRY("Education and Chemistry"),
    EDUCATION_AND_CHRISTIAN_RELIGIOUS_STUDIES("Education and Christian Religious Studies"),
    EDUCATION_AND_ECONOMICS("Education and Economics"),
    EDUCATION_AND_ENGLISH_LANGUAGE("Education and English Language"),
    EDUCATION_AND_FRENCH("Education and French"),
    EDUCATION_AND_GEOGRAPHY("Education and Geography"),
    EDUCATION_AND_HISTORY("Education and History"),
    EDUCATION_AND_IGBO("Education and Igbo"),
    EDUCATION_AND_INTEGRATED_SCIENCE("Education and Integrated Science"),
    EDUCATION_AND_ISLAMIC_STUDIES("Education and Islamic Studies"),
    EDUCATION_AND_MATHEMATICS("Education and Mathematics"),
    EDUCATION_AND_PHYSICS("Education and Physics"),
    EDUCATION_AND_YORUBA("Education and Yoruba"),
    EDUCATIONAL_ADMINISTRATION("Educational Administration"),
    ELECTRICAL_AND_ELECTRONICS_ENGINEERING("Electrical / Electronics Engineering"),
    ENGLISH_LANGUAGE("English Language"),
    ESTATE_MANAGEMENT("Estate Management"),
    FINANCE("Finance"),
    FISHERIES("Fisheries"),
    FISHERIES_MANAGEMENT("Fisheries Management"),
    FRENCH("French"),
    GEOGRAPHY("Geography"),
    GEOLOGY("Geology"),
    GEOPHYSICS("Geophysics"),
    GUIDANCE_AND_COUNSELING("Guidance and Counseling"),
    HEALTH_EDUCATION("Health Education"),
    HISTORY_AND_STRATEGIC_STUDIES("History and Strategic Studies"),
    HOME_ECONOMICS_AND_EDUCATION("Home Economics and Education"),
    HUMAN_KINETICS("Human Kinetics"),
    IGBO("Igbo"),
    INDUSTRIAL_CHEMISTRY("Industrial Chemistry"),
    INDUSTRIAL_MATHEMATICS("Industrial Mathematics"),
    INDUSTRIAL_RELATIONS_AND_PERSONNEL_MANAGEMENT("Industrial Relations and Personnel Management"),
    INSURANCE("Insurance"),
    ISLAMIC_STUDIES("Islamic Studies"),
    LAW("Law"),
    LINGUISTICS_IGBO_AND_OTHER_AFRICAN_LANGUAGES("Linguistics, Igbo and other African Languages"),
    MARINE_BIOLOGY("Marine Biology"),
    MASS_COMMUNICATION("Mass Communication"),
    MATHEMATICS("Mathematics"),
    MECHANICAL_ENGINEERING("Mechanical Engineering"),
    MEDICAL_LABORATORY_SCIENCE("Medical Laboratory Science"),
    MEDICINE_AND_SURGERY("Medicine and Surgery"),
    METALLURGICAL_AND_MATERIAL_ENGINEERING("Metallurgical and Material Engineering"),
    MICROBIOLOGY("Microbiology"),
    NURSING("Nursing / Nursing Science"),
    PETROLEUM_AND_GAS_ENGINEERING("Petroleum and Gas Engineering"),
    PHARMACOLOGY("Pharmacology"),
    PHARMACY("Pharmacy"),
    PHILOSOPHY("Philosophy"),
    PHYSICS("Physics"),
    PHYSIOLOGY("Physiology"),
    PHYSIOTHERAPY("Physiotherapy"),
    POLITICAL_SCIENCE("Political Science"),
    PSYCHOLOGY("Psychology"),
    QUANTITY_SURVEYING("Quantity Surveying"),
    RADIOGRAPHY("Radiography"),
    RUSSIAN_WITH_FRENCH_OR_GERMAN("Russian with French / German"),
    RUSSIAN("Russian"),
    SOCIAL_WORKS("Social Works"),
    SOCIOLOGY("Sociology"),
    STATISTICS("Statistics"),
    SURVEYING_AND_GEOINFORMATICS("Surveying and Geoinformatics"),
    SYSTEM_ENGINEERING("System Engineering"),
    TEACHER_EDUCATION_SCIENCE("Teacher Education Science"),
    TECHNICAL_EDUCATION("Technical Education"),
    URBAN_AND_REGIONAL_PLANNING("Urban and Regional Planning"),
    YORUBA("Yoruba"),
    ZOOLOGY("Zoology");


    private String value;
    
    private ProgrammeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
