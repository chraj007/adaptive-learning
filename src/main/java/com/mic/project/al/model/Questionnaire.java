package com.mic.project.al.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by veena on 27/12/17.
 */
@Entity
@Table(name = "questionnaire")

public class Questionnaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "learning_style")
    private String learningStyle;

    @Column(name = "q1")
    private String q1;

    @Column(name = "q2")
    private String q2;

    @Column(name = "q3")
    private String q3;


    @Column(name = "q4")
    private String q4;

    @Column(name = "q5")
    private String q5;

    @Column(name = "q6")
    private String q6;

    @Column(name = "q7")
    private String q7;

    @Column(name = "q8")
    private String q8;

    @Column(name = "q9")
    private String q9;

    @Column(name = "q10")
    private String q10;

    @Column(name = "q11")
    private String q11;

    @Column(name = "q12")
    private String q12;

    @Column(name = "q13")
    private String q13;

    @Column(name = "q14")
    private String q14;

    @Column(name = "q15")
    private String q15;

    @Column(name = "q16")
    private String q16;

    @Column(name = "q17")
    private String q17;

    @Column(name = "q18")
    private String q18;

    @Column(name = "q19")
    private String q19;

    @Column(name = "q20")
    private String q20;

    @Column(name = "q21")
    private String q21;

    @Column(name = "q22")
    private String q22;

    @Column(name = "q23")
    private String q23;

    @Column(name = "q24")
    private String q24;

    @Column(name = "q25")
    private String q25;

    @Column(name = "q26")
    private String q26;

    @Column(name = "q27")
    private String q27;

    @Column(name = "q28")
    private String q28;

    @Column(name = "q29")
    private String q29;

    @Column(name = "q30")
    private String q30;

    @Column(name = "q31")
    private String q31;

    @Column(name = "q32")
    private String q32;

    @Column(name = "q33")
    private String q33;

    @Column(name = "q34")
    private String q34;

    @Column(name = "q35")
    private String q35;

    @Column(name = "q36")
    private String q36;

    @Column(name = "q37")
    private String q37;

    @Column(name = "q38")
    private String q38;

    @Column(name = "q39")
    private String q39;

    @Column(name = "q40")
    private String q40;

    @Column(name = "q41")
    private String q41;

    @Column(name = "q42")
    private String q42;

    @Column(name = "q43")
    private String q43;


    @Column(name = "q44")
    private String q44;

    @Column(name = "q45")
    private String q45;

    @Column(name = "q46")
    private String q46;

    @Column(name = "q47")
    private String q47;

    @Column(name = "q48")
    private String q48;

    @Column(name = "q49")
    private String q49;

    @Column(name = "q50")
    private String q50;

    @Column(name = "q51")
    private String q51;

    @Column(name = "q52")
    private String q52;

    @Column(name = "q53")
    private String q53;

    @Column(name = "q54")
    private String q54;

    @Column(name = "q55")
    private String q55;

    @Column(name = "q56")
    private String q56;

    @Column(name = "q57")
    private String q57;

    @Column(name = "q58")
    private String q58;

    @Column(name = "q59")
    private String q59;

    @Column(name = "q60")
    private String q60;

    @Column(name = "q61")
    private String q61;

    @Column(name = "q62")
    private String q62;

    @Column(name = "q63")
    private String q63;

    @Column(name = "q64")
    private String q64;

    @Column(name = "q65")
    private String q65;

    @Column(name = "q66")
    private String q66;

    @Column(name = "q67")
    private String q67;

    @Column(name = "q68")
    private String q68;

    @Column(name = "q69")
    private String q69;

    @Column(name = "q70")
    private String q70;

    @Column(name = "q71")
    private String q71;

    @Column(name = "q72")
    private String q72;

    @Column(name = "q73")
    private String q73;

    @Column(name = "q74")
    private String q74;

    @Column(name = "q75")
    private String q75;

    @Column(name = "q76")
    private String q76;

    @Column(name = "q77")
    private String q77;

    @Column(name = "q78")
    private String q78;

    @Column(name = "q79")
    private String q79;

    @Column(name = "q80")
    private String q80;

    @Column(name = "pragma_count")
    int pragmaCount = 0;
    @Column(name = "activist_count")
    int activistCount = 0;
    @Column(name = "reflector_count")
    int reflectorCount = 0;
    @Column(name = "theorist_count")
    int theoristCount = 0;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        if (q1 != null && q1.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        if (q2 != null && q2.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        if (q3 != null && q3.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q3 = q3;
    }

    public String getQ4() {
        return q4;
    }

    public void setQ4(String q4) {
        if (q4 != null && q4.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q4 = q4;
    }

    public String getQ5() {
        return q5;
    }

    public void setQ5(String q5) {
        if (q5 != null && q5.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q5 = q5;
    }

    public String getQ6() {
        return q6;
    }

    public void setQ6(String q6) {
        if (q6 != null && q6.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q6 = q6;
    }

    public String getQ7() {
        return q7;
    }

    public void setQ7(String q7) {
        if (q7 != null && q7.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q7 = q7;
    }

    public String getQ8() {
        return q8;
    }

    public void setQ8(String q8) {
        if (q8 != null && q8.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q8 = q8;
    }

    public String getQ9() {
        return q9;
    }

    public void setQ9(String q9) {
        if (q9 != null && q9.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q9 = q9;
    }

    public String getQ10() {
        return q10;
    }

    public void setQ10(String q10) {
        if (q10 != null && q10.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q10 = q10;
    }

    public String getQ11() {
        return q11;
    }

    public void setQ11(String q11) {
        if (q11 != null && q11.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q11 = q11;
    }

    public String getQ12() {
        return q12;
    }

    public void setQ12(String q12) {
        if (q12 != null && q12.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q12 = q12;
    }

    public String getQ13() {
        return q13;
    }

    public void setQ13(String q13) {
        if (q13 != null && q13.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q13 = q13;
    }

    public String getQ14() {
        return q14;
    }

    public void setQ14(String q14) {
        if (q14 != null && q14.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q14 = q14;
    }

    public String getQ15() {
        return q15;
    }

    public void setQ15(String q15) {
        if (q15 != null && q15.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q15 = q15;
    }

    public String getQ16() {
        return q16;
    }

    public void setQ16(String q16) {
        if (q16 != null && q16.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q16 = q16;
    }

    public String getQ17() {
        return q17;
    }

    public void setQ17(String q17) {
        if (q17 != null && q17.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q17 = q17;
    }

    public String getQ18() {
        return q18;
    }

    public void setQ18(String q18) {
        if (q18 != null && q18.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q18 = q18;
    }

    public String getQ19() {
        return q19;
    }

    public void setQ19(String q19) {
        if (q19 != null && q19.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q19 = q19;
    }

    public String getQ20() {
        return q20;
    }

    public void setQ20(String q20) {
        if (q20 != null && q20.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q20 = q20;
    }

    public String getQ21() {
        return q21;
    }

    public void setQ21(String q21) {
        if (q21 != null && q21.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q21 = q21;
    }

    public String getQ22() {
        return q22;
    }

    public void setQ22(String q22) {
        if (q22 != null && q22.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q22 = q22;
    }

    public String getQ23() {
        return q23;
    }

    public void setQ23(String q23) {
        if (q23 != null && q23.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q23 = q23;
    }

    public String getQ24() {
        return q24;
    }

    public void setQ24(String q24) {
        if (q24 != null && q24.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q24 = q24;
    }

    public String getQ25() {
        return q25;
    }

    public void setQ25(String q25) {
        if (q25 != null && q25.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q25 = q25;
    }

    public String getQ26() {
        return q26;
    }

    public void setQ26(String q26) {
        if (q26 != null && q26.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q26 = q26;
    }

    public String getQ27() {
        return q27;
    }

    public void setQ27(String q27) {
        if (q27 != null && q27.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q27 = q27;
    }

    public String getQ28() {
        return q28;
    }

    public void setQ28(String q28) {
        if (q28 != null && q28.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q28 = q28;
    }

    public String getQ29() {
        return q29;
    }

    public void setQ29(String q29) {
        if (q29 != null && q29.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q29 = q29;
    }

    public String getQ30() {
        return q30;
    }

    public void setQ30(String q30) {
        if (q30 != null && q30.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q30 = q30;
    }

    public String getQ31() {
        return q31;
    }

    public void setQ31(String q31) {
        if (q31 != null && q31.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q31 = q31;
    }

    public String getQ32() {
        return q32;
    }

    public void setQ32(String q32) {
        if (q32 != null && q32.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q32 = q32;
    }

    public String getQ33() {
        return q33;
    }

    public void setQ33(String q33) {
        if (q33 != null && q33.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q33 = q33;
    }

    public String getQ34() {
        return q34;
    }

    public void setQ34(String q34) {
        if (q34 != null && q34.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q34 = q34;
    }

    public String getQ35() {
        return q35;
    }

    public void setQ35(String q35) {
        if (q35 != null && q35.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q35 = q35;
    }

    public String getQ36() {
        return q36;
    }

    public void setQ36(String q36) {
        if (q36 != null && q36.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q36 = q36;
    }

    public String getQ37() {
        return q37;
    }

    public void setQ37(String q37) {
        if (q37 != null && q37.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q37 = q37;
    }

    public String getQ38() {
        return q38;
    }

    public void setQ38(String q38) {
        if (q38 != null && q38.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q38 = q38;
    }

    public String getQ39() {
        return q39;
    }

    public void setQ39(String q39) {
        if (q39 != null && q39.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q39 = q39;
    }

    public String getQ40() {
        return q40;
    }

    public void setQ40(String q40) {
        if (q40 != null && q40.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q40 = q40;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQ41() {
        return q41;
    }

    public void setQ41(String q41) {
        if (q41 != null && q41.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q41 = q41;
    }

    public String getQ42() {
        return q42;
    }

    public void setQ42(String q42) {
        if (q42 != null && q42.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q42 = q42;
    }

    public String getQ43() {
        return q43;
    }

    public void setQ43(String q43) {
        if (q43 != null && q43.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q43 = q43;
    }

    public String getQ44() {
        return q44;
    }

    public void setQ44(String q44) {
        if (q44 != null && q44.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q44 = q44;
    }

    public String getQ45() {
        return q45;
    }

    public void setQ45(String q45) {
        if (q45 != null && q45.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q45 = q45;
    }

    public String getQ46() {
        return q46;
    }

    public void setQ46(String q46) {
        if (q46 != null && q46.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q46 = q46;
    }

    public String getQ47() {
        return q47;
    }

    public void setQ47(String q47) {
        if (q47 != null && q47.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q47 = q47;
    }

    public String getQ48() {
        return q48;
    }

    public void setQ48(String q48) {
        if (q48 != null && q48.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q48 = q48;
    }

    public String getQ49() {
        return q49;
    }

    public void setQ49(String q49) {
        if (q49 != null && q49.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q49 = q49;
    }

    public String getQ50() {
        return q50;
    }

    public void setQ50(String q50) {
        if (q50 != null && q50.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q50 = q50;
    }

    public String getQ51() {
        return q51;
    }

    public void setQ51(String q51) {
        if (q51 != null && q51.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q51 = q51;
    }

    public String getQ52() {
        return q52;
    }

    public void setQ52(String q52) {
        if (q52 != null && q52.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q52 = q52;
    }

    public String getQ53() {
        return q53;
    }

    public void setQ53(String q53) {
        if (q53 != null && q53.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q53 = q53;
    }

    public String getQ54() {
        return q54;
    }

    public void setQ54(String q54) {
        if (q54 != null && q54.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q54 = q54;
    }

    public String getQ55() {
        return q55;
    }

    public void setQ55(String q55) {
        if (q55 != null && q55.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q55 = q55;
    }

    public String getQ56() {
        return q56;
    }

    public void setQ56(String q56) {
        if (q56 != null && q56.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q56 = q56;
    }

    public String getQ57() {
        return q57;
    }

    public void setQ57(String q57) {
        if (q57 != null && q57.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q57 = q57;
    }

    public String getQ58() {
        return q58;
    }

    public void setQ58(String q58) {
        if (q58 != null && q58.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q58 = q58;
    }

    public String getQ59() {
        return q59;
    }

    public void setQ59(String q59) {
        if (q59 != null && q59.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q59 = q59;
    }

    public String getQ60() {
        return q60;
    }

    public void setQ60(String q60) {
        if (q60 != null && q60.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q60 = q60;
    }

    public String getQ61() {
        return q61;
    }

    public void setQ61(String q61) {
        if (q61 != null && q61.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q61 = q61;
    }

    public String getQ62() {
        return q62;
    }

    public void setQ62(String q62) {
        if (q62 != null && q62.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q62 = q62;
    }

    public String getQ63() {
        return q63;
    }

    public void setQ63(String q63) {
        if (q63 != null && q63.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q63 = q63;
    }

    public String getQ64() {
        return q64;
    }

    public void setQ64(String q64) {
        if (q64 != null && q64.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q64 = q64;
    }

    public String getQ65() {
        return q65;
    }

    public void setQ65(String q65) {
        if (q65 != null && q65.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q65 = q65;
    }

    public String getQ66() {
        return q66;
    }

    public void setQ66(String q66) {
        if (q66 != null && q66.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q66 = q66;
    }

    public String getQ67() {
        return q67;
    }

    public void setQ67(String q67) {
        if (q67 != null && q67.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q67 = q67;
    }

    public String getQ68() {
        return q68;
    }

    public void setQ68(String q68) {
        if (q68 != null && q68.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q68 = q68;
    }

    public String getQ69() {
        return q69;
    }

    public void setQ69(String q69) {
        if (q69 != null && q69.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q69 = q69;
    }

    public String getQ70() {
        return q70;
    }

    public void setQ70(String q70) {
        if (q70 != null && q70.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q70 = q70;
    }

    public String getQ71() {
        return q71;
    }

    public void setQ71(String q71) {
        if (q71 != null && q71.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q71 = q71;
    }

    public String getQ72() {
        return q72;
    }

    public void setQ72(String q72) {
        if (q72 != null && q72.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q72 = q72;
    }

    public String getQ73() {
        return q73;
    }

    public void setQ73(String q73) {
        if (q73 != null && q73.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q73 = q73;
    }

    public String getQ74() {
        return q74;
    }

    public void setQ74(String q74) {
        if (q74 != null && q74.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q74 = q74;
    }

    public String getQ75() {
        return q75;
    }

    public void setQ75(String q75) {
        if (q75 != null && q75.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q75 = q75;
    }

    public String getQ76() {
        return q76;
    }

    public void setQ76(String q76) {
        if (q76 != null && q76.equalsIgnoreCase("yes")) {
            reflectorCount++;
        }
        this.q76 = q76;
    }

    public String getQ77() {
        return q77;
    }

    public void setQ77(String q77) {
        if (q77 != null && q77.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q77 = q77;
    }

    public String getQ78() {
        return q78;
    }

    public void setQ78(String q78) {
        if (q78 != null && q78.equalsIgnoreCase("yes")) {
            theoristCount++;
        }
        this.q78 = q78;
    }

    public String getQ79() {
        return q79;
    }

    public void setQ79(String q79) {
        if (q79 != null && q79.equalsIgnoreCase("yes")) {
            activistCount++;
        }
        this.q79 = q79;
    }

    public String getQ80() {
        return q80;
    }

    public void setQ80(String q80) {
        if (q80 != null && q80.equalsIgnoreCase("yes")) {
            pragmaCount++;
        }
        this.q80 = q80;
    }

    public String getLearningStyle() {
        return learningStyle;
    }

    public void setLearningStyle(String learningStyle) {
        this.learningStyle = learningStyle;
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", q1='" + q1 + '\'' +
                ", q2='" + q2 + '\'' +
                ", q3='" + q3 + '\'' +
                ", q4='" + q4 + '\'' +
                ", q5='" + q5 + '\'' +
                ", q6='" + q6 + '\'' +
                ", q7='" + q7 + '\'' +
                ", q8='" + q8 + '\'' +
                ", q9='" + q9 + '\'' +
                ", q10='" + q10 + '\'' +
                ", q11='" + q11 + '\'' +
                ", q12='" + q12 + '\'' +
                ", q13='" + q13 + '\'' +
                ", q14='" + q14 + '\'' +
                ", q15='" + q15 + '\'' +
                ", q16='" + q16 + '\'' +
                ", q17='" + q17 + '\'' +
                ", q18='" + q18 + '\'' +
                ", q19='" + q19 + '\'' +
                ", q20='" + q20 + '\'' +
                ", q21='" + q21 + '\'' +
                ", q22='" + q22 + '\'' +
                ", q23='" + q23 + '\'' +
                ", q24='" + q24 + '\'' +
                ", q25='" + q25 + '\'' +
                ", q26='" + q26 + '\'' +
                ", q27='" + q27 + '\'' +
                ", q28='" + q28 + '\'' +
                ", q29='" + q29 + '\'' +
                ", q30='" + q30 + '\'' +
                ", q31='" + q31 + '\'' +
                ", q32='" + q32 + '\'' +
                ", q33='" + q33 + '\'' +
                ", q34='" + q34 + '\'' +
                ", q35='" + q35 + '\'' +
                ", q36='" + q36 + '\'' +
                ", q37='" + q37 + '\'' +
                ", q38='" + q38 + '\'' +
                ", q39='" + q39 + '\'' +
                ", q40='" + q40 + '\'' +
                ", q41='" + q41 + '\'' +
                ", q42='" + q42 + '\'' +
                ", q43='" + q43 + '\'' +
                ", q44='" + q44 + '\'' +
                ", q45='" + q45 + '\'' +
                ", q46='" + q46 + '\'' +
                ", q47='" + q47 + '\'' +
                ", q48='" + q48 + '\'' +
                ", q49='" + q49 + '\'' +
                ", q50='" + q50 + '\'' +
                ", q51='" + q51 + '\'' +
                ", q52='" + q52 + '\'' +
                ", q53='" + q53 + '\'' +
                ", q54='" + q54 + '\'' +
                ", q55='" + q55 + '\'' +
                ", q56='" + q56 + '\'' +
                ", q57='" + q57 + '\'' +
                ", q58='" + q58 + '\'' +
                ", q59='" + q59 + '\'' +
                ", q60='" + q60 + '\'' +
                ", q61='" + q61 + '\'' +
                ", q62='" + q62 + '\'' +
                ", q63='" + q63 + '\'' +
                ", q64='" + q64 + '\'' +
                ", q65='" + q65 + '\'' +
                ", q66='" + q66 + '\'' +
                ", q67='" + q67 + '\'' +
                ", q68='" + q68 + '\'' +
                ", q69='" + q69 + '\'' +
                ", q70='" + q70 + '\'' +
                ", q71='" + q71 + '\'' +
                ", q72='" + q72 + '\'' +
                ", q73='" + q73 + '\'' +
                ", q74='" + q74 + '\'' +
                ", q75='" + q75 + '\'' +
                ", q76='" + q76 + '\'' +
                ", q77='" + q77 + '\'' +
                ", q78='" + q78 + '\'' +
                ", q79='" + q79 + '\'' +
                ", q80='" + q80 + '\'' +
                '}';
    }

    public int getPragmaCount() {
        return pragmaCount;
    }

    public int getActivistCount() {
        return activistCount;
    }

    public int getReflectorCount() {
        return reflectorCount;
    }

    public int getTheoristCount() {
        return theoristCount;
    }

    public void setPragmaCount(int pragmaCount) {
        this.pragmaCount = pragmaCount;
    }

    public void setActivistCount(int activistCount) {
        this.activistCount = activistCount;
    }

    public void setReflectorCount(int reflectorCount) {
        this.reflectorCount = reflectorCount;
    }

    public void setTheoristCount(int theoristCount) {
        this.theoristCount = theoristCount;
    }
}
