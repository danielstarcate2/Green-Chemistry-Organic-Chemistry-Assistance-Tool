import java.util.*;


public class ReactionDatabase {

    private static Map<String, List<Reaction>> reactionMap = new LinkedHashMap<>();

    static {
        initializeData();
    }
    public static class Reaction {
        private String traditional;
        private String greenAlternative;
        private String notes;
        private String safety;
        private String imagePath;

        public Reaction(String traditional, String greenAlternative, String notes, String safety, String imagePath) {
            this.traditional = traditional;
            this.greenAlternative = greenAlternative;
            this.notes = notes;
            this.safety = safety;
            this.imagePath = imagePath;
        }

        @Override
        public String toString() {
            return String.format("Traditional: %s\nGreen Alternative: %s\nNotes: %s\nSafety: %s\n",
                    traditional, greenAlternative, notes, safety);
        }

        public String getImagePath() {
            return imagePath;
        }
    }
    private static void addReaction(List<Reaction> list, String traditional, String green, String notes, String safety, String imagePath) {
        list.add(new Reaction(traditional, green, notes, safety, imagePath));
    }
    private static void initializeData() {

        /**
         * Alkanes
         */
        List<Reaction> alkanes = new ArrayList<>();
        addReaction(alkanes, "Free radical chlorination [hν, Cl2]", "N/A", "Radical substitution", "Cl2 is toxic and corrosive", "/Resources/Reaction_Images/alkanes/free_radical_chlorination.gif");
        addReaction(alkanes, "Free radical bromination [hν, Br2]", "N/A", "Radical substitution", "Br2 is toxic and corrosive", "/Resources/Reaction_Images/alkanes/free_radical_bromination.gif");
        addReaction(alkanes, "Allylic bromination [NBS]", "N/A", "Selective allylic bromination", "NBS is toxic; handle in fume hood", "/Resources/Reaction_Images/alkanes/allylic_bromination.gif");
        reactionMap.put("Alkanes", alkanes);

        /**
         * Alkenes
         */
        List<Reaction> alkenes = new ArrayList<>();
        addReaction(alkenes, "Addition of HCl", "Use Aqueous HCl: (AQ)HCl reduces exposure to concentrated HCl gas, which is corrosive, volatile, and hazardous to handle. Dilution lowers vapor formation, simplifies neutralization, and decreases environmental release of strong acids.", "Electrophilic addition", "Corrosive", "/Resources/Reaction_Images/Alkenes/addition_hcl.gif");
        addReaction(alkenes, "Addition of HBr", "Use Aqueous HBr: (AQ) and Ideally Dilute HBr eliminates the dangers of handling fuming HBr or anhydrous HBr. Aqueous solutions create fewer airborne acid particles to reduce corrosive damage. (AQ) HBr is also safer to handle.", "Electrophilic addition", "Corrosive", "/Resources/Reaction_Images/alkenes/addition_hbr.gif");
        addReaction(alkenes, "Addition of H3O(+)", "Use catalytic acid", "Hydration to alcohols", "Corrosive", "/Resources/Reaction_Images/alkenes/addition_h3o.gif");
        addReaction(alkenes, "Addition of HI", "Use aqueous HI", "Electrophilic addition", "Corrosive", "/Resources/Reaction_Images/alkenes/addition_hi.gif");
        addReaction(alkenes, "Chlorination [Cl2]", "Use Cl2 in water", "Halogen addition", "Cl2 is toxic", "/Resources/Reaction_Images/alkenes/chlorination.gif");
        addReaction(alkenes, "Bromination [Br2]", "Use Br2 in water", "Halogen addition", "Br2 is toxic", "/Resources/Reaction_Images/alkenes/bromination.gif");
        addReaction(alkenes, "Iodination [I2]", "Use I2 in water", "Halogen addition", "I2 is corrosive", "/Resources/Reaction_Images/alkenes/iodination.gif");
        addReaction(alkenes, "Chlorohydrin formation [Cl2/H2O]", "N/A", "Forms halohydrins", "Corrosive", "/Resources/Reaction_Images/alkenes/chlorohydrin.gif");
        addReaction(alkenes, "Bromohydrin formation [Br2/H2O]", "N/A", "Forms halohydrins", "Corrosive", "/Resources/Reaction_Images/alkenes/bromohydrin.gif");
        addReaction(alkenes, "Ether Formation [H+/ROH]", "Use safer alcohols", "Forms ethers", "Corrosive", "/Resources/Reaction_Images/alkenes/ether_formation.gif");
        addReaction(alkenes, "Oxymercuration [Hg(OAc)2/H2O]", "Use aqueous Hg(OAc)2", "Markovnikov addition", "Mercury is toxic", "/Resources/Reaction_Images/alkenes/oxymercuration_h2o.gif");
        addReaction(alkenes, "Oxymercuration [Hg(OAc)2/ROH]", "Use alcohols as solvent", "Markovnikov addition", "Mercury is toxic", "/Resources/Reaction_Images/alkenes/oxymercuration_roh.gif");
        addReaction(alkenes, "Hydroboration", "Use BH3 in THF", "Anti-Markovnikov addition", "Flammable, reactive", "/Resources/Reaction_Images/alkenes/hydroboration.gif");
        addReaction(alkenes, "Epoxidation [RCO3H]", "Use H2O2 + NaHCO3", "Forms epoxides", "Oxidizer", "/Resources/Reaction_Images/alkenes/epoxidation.gif");
        addReaction(alkenes, "Dihydroxylation [OsO4]", "Use catalytic OsO4", "Forms diols", "Highly toxic", "/Resources/Reaction_Images/alkenes/dihydroxylation_os.gif");
        addReaction(alkenes, "Dihydroxylation [KMnO4]", "Use dilute KMnO4", "Forms diols", "Strong oxidizer", "/Resources/Reaction_Images/alkenes/dihydroxylation_kmn.gif");
        addReaction(alkenes, "Cyclopropanation (Simmons-Smith)", "Use Zn-Cu/CH2I2", "Forms cyclopropanes", "Flammable", "/Resources/Reaction_Images/alkenes/cyclopropanation.gif");
        addReaction(alkenes, "Dichlorocyclopropanation", "N/A", "Forms dichlorocyclopropanes", "Corrosive", "/Resources/Reaction_Images/alkenes/dichlorocyclopropanation.gif");
        addReaction(alkenes, "Ozonolysis (Reductive workup)", "Use Zn/CH3COOH", "Cleaves double bonds", "Ozone is toxic", "/Resources/Reaction_Images/alkenes/ozonolysis_reductive.gif");
        addReaction(alkenes, "Ozonolysis (Oxidative workup)", "Use H2O2", "Cleaves double bonds", "Ozone is toxic", "/Resources/Reaction_Images/alkenes/ozonolysis_oxidative.gif");
        addReaction(alkenes, "Oxidative Cleavage [KMnO4]", "Dilute KMnO4", "Cleaves double bonds", "Strong oxidizer", "/Resources/Reaction_Images/alkenes/oxidative_cleavage.gif");
        addReaction(alkenes, "Hydrogenation", "Use H2 + Pd/C", "Reduces double bonds", "Flammable", "/Resources/Reaction_Images/alkenes/hydrogenation.gif");
        addReaction(alkenes, "Rearrangements (H shift)", "N/A", "Hydride shifts", "Heat sensitive", "/Resources/Reaction_Images/alkenes/rearrangement_h.gif");
        addReaction(alkenes, "Rearrangements (Alkyl shift)", "N/A", "Alkyl shifts", "Heat sensitive", "/Resources/Reaction_Images/alkenes/rearrangement_alkyl.gif");
        addReaction(alkenes, "Free Radical Addition of HBr", "Use peroxide-free conditions", "Anti-Markovnikov addition", "Peroxides are flammable", "/Resources/Reaction_Images/alkenes/free_radical_hbr.gif");
        addReaction(alkenes, "Sharpless Epoxidation", "Use Ti(OiPr)4 + tartrate", "Asymmetric epoxidation", "Corrosive", "/Resources/Reaction_Images/alkenes/sharpless_epoxidation.gif");
        reactionMap.put("Alkenes", alkenes);

        /**
         * Alkynes
         */
        List<Reaction> alkynes = new ArrayList<>();
        addReaction(alkynes, "Deprotonation (acetylide formation)", "Use NaH or NaNH2", "Forms nucleophilic acetylides", "Strong bases are corrosive", "/Resources/Reaction_Images/alkynes/deprotonation_acetylide.gif");
        addReaction(alkynes, "SN2 with alkyl halides", "Use NaNH2 in THF", "Alkylation of acetylides", "Strong base", "/Resources/Reaction_Images/alkynes/sn2_alkyl.gif");
        addReaction(alkynes, "Partial reduction (Lindlar)", "Use Lindlar catalyst", "Cis-alkene formation", "Catalyst sensitive", "/Resources/Reaction_Images/alkynes/partial_reduction_lindlar.gif");
        addReaction(alkynes, "Partial reduction [Na/NH3]", "Use Na/NH3", "Trans-alkene formation", "Highly reactive", "/Resources/Reaction_Images/alkynes/partial_reduction_na_nh3.gif");
        addReaction(alkynes, "Hydroboration", "Use BH3", "Forms cis-alkenes", "Flammable", "/Resources/Reaction_Images/alkynes/hydroboration.gif");
        addReaction(alkynes, "Oxymercuration", "Use Hg(OAc)2/H2O", "Forms ketones", "Mercury toxic", "/Resources/Reaction_Images/alkynes/oxymercuration.gif");
        addReaction(alkynes, "Addition of HCl, HBr, or HI (once)", "N/A", "Markovnikov addition", "Corrosive", "/Resources/Reaction_Images/alkynes/addition_once.gif");
        addReaction(alkynes, "Addition of HCl, HBr, or HI (twice)", "N/A", "Dihalide formation", "Corrosive", "/Resources/Reaction_Images/alkynes/addition_twice.gif");
        addReaction(alkynes, "Hydrogenation", "Use H2/Pd-C", "Reduces triple bond", "Flammable", "/Resources/Reaction_Images/alkynes/hydrogenation.gif");
        addReaction(alkynes, "Ozonolysis", "Use O3", "Cleaves triple bonds", "Ozone toxic", "/Resources/Reaction_Images/alkynes/ozonolysis.gif");
        addReaction(alkynes, "Oxidative cleavage [KMnO4]", "Dilute KMnO4", "Forms carboxylic acids", "Strong oxidizer", "/Resources/Reaction_Images/alkynes/oxidative_cleavage.gif");
        addReaction(alkynes, "Alkyne formation via elimination", "Use strong base", "Forms triple bond", "Strong base", "/Resources/Reaction_Images/alkynes/formation_elimination.gif");
        addReaction(alkynes, "Halogenation [Cl2, Br2, I2]", "Use X2. X2 is 100% atom efficient when compared to traditional sources, maximizing yield and minimizing yield. Being a noble gas X2 is also inert", "Adds halogens", "Toxic halogens", "/Resources/Reaction_Images/alkynes/halogenation.gif");
        reactionMap.put("Alkynes", alkynes);

        /**
         * SN2 Substitution
         */
        List<Reaction> sn2 = new ArrayList<>();
        addReaction(sn2, "Alcohol formation [HO–]", "Use NaOH in water", "Nucleophilic substitution", "Strong base; corrosive", "/Resources/Reaction_Images/sn2/alcohol_formation_ho.gif");
        addReaction(sn2, "Alcohol formation [H2O]", "Use aqueous ethanol", "Nucleophilic substitution", "Mildly acidic/corrosive", "/Resources/Reaction_Images/sn2/alcohol_formation_h2o.gif");
        addReaction(sn2, "Nitrile formation [CN–]", "KCN in ethanol/water", "Nucleophilic substitution", "Cyanide highly toxic", "/Resources/Reaction_Images/sn2/nitrile_formation.gif");
        addReaction(sn2, "Thiol formation [HS–]", "NaSH in water", "Nucleophilic substitution", "Toxic odor", "/Resources/Reaction_Images/sn2/thiol_formation.gif");
        addReaction(sn2, "Ether formation [RO–] (Williamson)", "Use K2CO3", "Ether synthesis", "Corrosive", "/Resources/Reaction_Images/sn2/ether_formation.gif");
        addReaction(sn2, "Thioether formation [RS–]", "Use K2CO3", "Thioether synthesis", "Corrosive", "/Resources/Reaction_Images/sn2/thioether_formation.gif");
        addReaction(sn2, "Azides [N3–]", "Use NaN3", "Nucleophilic substitution", "Explosive azides; toxic", "/Resources/Reaction_Images/sn2/azide_formation.gif");
        addReaction(sn2, "Ester formation [RCO2–]", "Use Na carboxylate", "Nucleophilic substitution", "Corrosive", "/Resources/Reaction_Images/sn2/ester_formation.gif");
        addReaction(sn2, "Acetylide addition [RC≡C–]", "Use NaNH2", "Alkyne alkylation", "Strong base; reactive", "/Resources/Reaction_Images/sn2/acetylide_addition.gif");
        addReaction(sn2, "Alkanes [Gilman reagents]", "Use R2CuLi", "Coupling reactions", "Air/moisture sensitive", "/Resources/Reaction_Images/sn2/gilman_reaction.gif");
        addReaction(sn2, "Alcohol formation [thru ether cleavage]", "Acid catalyzed", "Alcohol from ethers", "Corrosive", "/Resources/Reaction_Images/sn2/alcohol_from_ether.gif");
        addReaction(sn2, "Ammonium salt formation [RNH2]", "Use alkyl halides", "Forms quaternary ammonium salts", "Corrosive", "/Resources/Reaction_Images/sn2/ammonium_salt.gif");
        reactionMap.put("SN2 Substitution Reactions", sn2);

        /**
         * SN1 Substitution
         */
        List<Reaction> sn1 = new ArrayList<>();
        addReaction(sn1, "Alcohol formation [H2O]", "Use aqueous ethanol", "Nucleophilic substitution", "Corrosive", "/Resources/Reaction_Images/sn1/alcohol_formation.gif");
        addReaction(sn1, "Ether formation [ROH]", "Use alcohol solvent", "Nucleophilic substitution", "Corrosive", "/Resources/Reaction_Images/sn1/ether_formation.gif");
        addReaction(sn1, "Alcohol formation [ether cleavage]", "Acid catalyzed", "Forms alcohols", "Corrosive", "/Resources/Reaction_Images/sn1/alcohol_from_ether.gif");
        addReaction(sn1, "Alkyl chloride formation [HCl]", "Use NaCl with acid", "Forms alkyl chlorides", "HCl toxic", "/Resources/Reaction_Images/sn1/alkyl_chloride.gif");
        addReaction(sn1, "Alkyl bromide formation [HBr]", "Use NaBr with acid", "Forms alkyl bromides", "HBr toxic", "/Resources/Reaction_Images/sn1/alkyl_bromide.gif");
        addReaction(sn1, "Alkyl iodide formation [HI]", "Use NaI with acid", "Forms alkyl iodides", "HI toxic", "/Resources/Reaction_Images/sn1/alkyl_iodide.gif");
        addReaction(sn1, "SN1 w/ rearrangement [alkyl shift]", "N/A", "Carbocation rearrangement", "Corrosive", "/Resources/Reaction_Images/sn1/alkyl_shift.gif");
        addReaction(sn1, "SN1 w/ rearrangement [hydride shift]", "N/A", "Carbocation rearrangement", "Corrosive", "/Resources/Reaction_Images/sn1/hydride_shift.gif");
        reactionMap.put("SN1 Substitution Reactions", sn1);

        /**
         * Elimination
         */
        List<Reaction> elimination = new ArrayList<>();
        addReaction(elimination, "E2: Alkenes from alkyl halides", "Use strong base", "Bimolecular elimination", "Strong base", "/Resources/Reaction_Images/elimination/e2_alkyl_halides.gif");
        addReaction(elimination, "Alkenes from alcohols [strong acid]", "Use H2SO4", "Acid-catalyzed dehydration", "Corrosive", "/Resources/Reaction_Images/elimination/alcohols_acid.gif");
        addReaction(elimination, "Alkenes from alcohols [POCl3]", "Use POCl3/pyridine", "Dehydration", "Corrosive", "/Resources/Reaction_Images/elimination/alcohols_pocl3.gif");
        addReaction(elimination, "E1: Alkenes from alkyl halides", "Use weak base", "Unimolecular elimination", "Corrosive", "/Resources/Reaction_Images/elimination/e1_alkyl_halides.gif");
        addReaction(elimination, "E1 with rearrangement [alkyl shift]", "N/A", "Carbocation rearrangement", "Corrosive", "/Resources/Reaction_Images/elimination/e1_alkyl_shift.gif");
        addReaction(elimination, "Hofmann Elimination", "Use quaternary ammonium hydroxides", "Forms less substituted alkenes", "Strong base", "/Resources/Reaction_Images/elimination_hofmann.gif");
        addReaction(elimination, "Alkyne formation via elimination", "Strong base", "Forms triple bond", "Strong base", "/Resources/Reaction_Images/elimination/alkyne_formation.gif");
        addReaction(elimination, "E1 with rearrangement [hydride shift]", "N/A", "Carbocation rearrangement", "Corrosive", "/Resources/Reaction_Images/elimination/e1_hydride_shift.gif");
        reactionMap.put("Elimination Reactions", elimination);

        /**
         * Organometallics
         */
        List<Reaction> organometallics = new ArrayList<>();
        addReaction(organometallics, "Grignard formation [alkyl halides]", "Mg in ether", "Forms RMgX", "Air/moisture sensitive", "/Resources/Reaction_Images/organometallics/grignard_alkyl.gif");
        addReaction(organometallics, "Grignard formation [alkenyl halides]", "Mg in ether", "Forms RMgX", "Air/moisture sensitive", "/Resources/Reaction_Images/organometallics/grignard_alkenyl.gif");
        addReaction(organometallics, "Reaction of Grignards with acid [H+]", "Quench carefully", "Forms hydrocarbons", "Exothermic", "/Resources/Reaction_Images/organometallics/grignard_acid.gif");
        addReaction(organometallics, "Addition of Grignards to aldehydes", "USE Tetrahydrofuran (THF). THF is less toxic, forms fewer hazardous peroxides, and has safer physical properties like a higher boiling point and lower water misclibility", "Forms alcohols", "Reactive", "/Resources/Reaction_Images/organometallics/grignard_aldehyde.gif");
        addReaction(organometallics, "Addition of Grignards to ketones", "USE Tetrahydrofuran (THF). THF is less toxic, forms fewer hazardous peroxides, and has safer physical properties like a higher boiling point and lower water misclibility", "Forms tertiary alcohols", "Reactive", "/Resources/Reaction_Images/organometallics/grignard_ketone.gif");
        addReaction(organometallics, "Addition of Grignards to esters", "USE Tetrahydrofuran (THF). THF is less toxic, forms fewer hazardous peroxides, and has safer physical properties like a higher boiling point and lower water misclibility", "Forms tertiary alcohols", "Reactive", "/Resources/Reaction_Images/organometallics/grignard_ester.gif");
        addReaction(organometallics, "Reaction of Grignards with CO2", "Use dry ice", "Forms carboxylic acids", "Exothermic", "/Resources/Reaction_Images/organometallics/grignard_co2.gif");
        addReaction(organometallics, "Addition of Grignards to nitriles", "USE Tetrahydrofuran (THF). THF is less toxic, forms fewer hazardous peroxides, and has safer physical properties like a higher boiling point and lower water misclibility", "Forms ketones", "Reactive", "/Resources/Reaction_Images/organometallics/grignard_nitrile.gif");
        addReaction(organometallics, "Formation of organolithium reagents", "Use Li metal", "Highly reactive", "Air/moisture sensitive", "/Resources/Reaction_Images/organometallics/organolithium.gif");
        addReaction(organometallics, "Formation of Gilman reagents", "Use Cu(I) salts", "Coupling reagent", "Air/moisture sensitive", "/Resources/Reaction_Images/organometallics/gilman.gif");
        addReaction(organometallics, "SN2 with Gilman reagents", "Use R2CuLi", "Coupling", "Air/moisture sensitive", "/Resources/Reaction_Images/organometallics/sn2_gilman.gif");
        addReaction(organometallics, "Addition of Gilman reagents to enones", "N/A", "Conjugate addition", "Air/moisture sensitive", "/Resources/Reaction_Images/organometallics/gilman_enone.gif");
        addReaction(organometallics, "Addition of Gilman to acyl halides", "N/A", "Forms ketones", "Air/moisture sensitive", "/Resources/Reaction_Images/organometallics/gilman_acyl.gif");
        addReaction(organometallics, "Heck Reaction", "Pd-catalyzed", "Forms substituted alkenes", "Toxic/flammable", "/Resources/Reaction_Images/organometallics/heck.gif");
        addReaction(organometallics, "Suzuki Reaction", "Pd-catalyzed", "Coupling reaction", "Toxic/flammable", "/Resources/Reaction_Images/organometallics/suzuki.gif");
        addReaction(organometallics, "Stille Reaction", "Pd-catalyzed", "Coupling reaction", "Toxic/flammable", "/Resources/Reaction_Images/organometallics/stille.gif");
        addReaction(organometallics, "Olefin Metathesis", "Grubbs catalyst", "Forms new alkenes", "Sensitive catalyst", "/Resources/Reaction_Images/organometallics/metathesis.gif");
        addReaction(organometallics, "Addition of R-Li To Aldehydes and Ketones", "USE Tetrahydrofuran (THF). THF is less toxic, forms fewer hazardous peroxides, and has safer physical properties like a higher boiling point and lower water misclibility", "Forms alcohols", "Reactive, flammable", "/Resources/Reaction_Images/organometallics/rli_alcohols.gif");
        addReaction(organometallics, "Double Addition of R-Li To Carboxylic Acids", "USE Tetrahydrofuran (THF). THF is less toxic, forms fewer hazardous peroxides, and has safer physical properties like a higher boiling point and lower water misclibility", "Forms alcohols", "Reactive, flammable", "/Resources/Reaction_Images/organometallics/rli_carboxylic.gif");
        reactionMap.put("Reactions of Organometallics", organometallics);

        /**
         * Expoxides
         */
        List<Reaction> epoxides = new ArrayList<>();
        addReaction(epoxides, "Epoxide opening [basic conditions]", "Use aqueous base", "Forms diols", "Strong base; corrosive", "/Resources/Reaction_Images/epoxides/opening_basic.gif");
        addReaction(epoxides, "Epoxide opening [acidic conditions]", "Use mild acid", "Forms diols", "Corrosive", "/Resources/Reaction_Images/epoxides/opening_acidic.gif");
        addReaction(epoxides, "Epoxide opening [diol formation]", "Use water and catalyst", "Forms vicinal diols", "Corrosive", "/Resources/Reaction_Images/epoxides/opening_diol.gif");
        addReaction(epoxides, "Epoxide formation [from halohydrins]", "Use base", "Ring closure", "Strong base", "/Resources/Reaction_Images/epoxides/formation_halohydrin.gif");
        addReaction(epoxides, "Epoxide formation [from alkenes]", "Use peracid", "Forms epoxides", "Oxidizer; explosive", "/Resources/Reaction_Images/epoxides/formation_alkene.gif");
        addReaction(epoxides, "Sharpless Epoxidation of alkenes", "Use Ti(OiPr)4 and tartrate", "Enantioselective epoxidation", "Toxic; air sensitive", "/Resources/Reaction_Images/epoxides/sharpless.gif");
        reactionMap.put("Reactions of Epoxides", epoxides);

        /**
         * Alcohols and Thiols
         */
        List<Reaction> alcoholsThiols = new ArrayList<>();
        addReaction(alcoholsThiols, "Deprotonation [alkoxide formation]", "Use NaH or Na metal", "Generates nucleophiles", "Strong base; reactive", "/Resources/Reaction_Images/alcohols_thiols/deprotonation.gif");
        addReaction(alcoholsThiols, "Protonation [onium ion formation]", "Use strong acid", "Activates leaving group", "Corrosive", "/Resources/Reaction_Images/alcohols_thiols/protonation.gif");
        addReaction(alcoholsThiols, "Conversion to ethers [Williamson reaction]", "Use alkoxide", "Ether synthesis", "Strong base", "/Resources/Reaction_Images/alcohols_thiols/williamson.gif");
        addReaction(alcoholsThiols, "Conversion to tosylates/mesylates", "Use TsCl or MsCl", "Activate alcohol", "Corrosive; irritant", "/Resources/Reaction_Images/alcohols_thiols/tosylate_mesylate.gif");
        addReaction(alcoholsThiols, "Conversion to alkyl chlorides [SOCl2]", "Use SOCl2", "Forms alkyl chlorides", "Toxic; corrosive", "/Resources/Reaction_Images/alcohols_thiols/soCl2.gif");
        addReaction(alcoholsThiols, "Conversion to alkyl bromides [PBr3]", "Use PBr3", "Forms alkyl bromides", "Toxic; corrosive", "/Resources/Reaction_Images/alcohols_thiols/pBr3.gif");
        addReaction(alcoholsThiols, "Oxidation to aldehydes [PCC]", "Use PCC", "Mild oxidation", "Cr compound; toxic", "/Resources/Reaction_Images/alcohols_thiols/oxidation_aldehyde.gif");
        addReaction(alcoholsThiols, "Oxidation to ketones [PCC + others]", "Use PCC or alternative", "Forms ketones", "Cr compound; toxic", "/Resources/Reaction_Images/alcohols_thiols/oxidation_ketone.gif");
        addReaction(alcoholsThiols, "Oxidation to carboxylic acids [H2CrO4 + others]", "Use safer oxidants", "Forms carboxylic acids", "Corrosive; toxic", "/Resources/Reaction_Images/alcohols_thiols/oxidation_acid.gif");
        addReaction(alcoholsThiols, "Protection as silyl ethers", "Use TBSCl", "Protect alcohols", "Moisture sensitive", "/Resources/Reaction_Images/alcohols_thiols/silyl_ether.gif");
        addReaction(alcoholsThiols, "Thiol formation [SN2]", "Use thiol nucleophile", "Forms thiols", "Toxic odor", "/Resources/Reaction_Images/alcohols_thiols/thiol_sn2.gif");
        addReaction(alcoholsThiols, "Thiol oxidation to disulfides", "Use mild oxidant", "Forms disulfides", "Oxidizer", "/Resources/Reaction_Images/alcohols_thiols/disulfide.gif");
        reactionMap.put("Reactions of Alcohols and Thiols", alcoholsThiols);

        /**
         * Dienes
         */
        List<Reaction> dienes = new ArrayList<>();
        addReaction(dienes, "Diels–Alder reaction", "Thermal or Lewis acid", "Cycloaddition", "Exothermic", "/Resources/Reaction_Images/dienes/diels_alder.gif");
        addReaction(dienes, "1,2 And 1,4 Addition To Dienes", "Use appropriate reagents", "Regioselective addition", "Reactive", "/Resources/Reaction_Images/dienes/1_2_1_4_addition.gif");
        addReaction(dienes, "Polymerization of dienes", "Use radical initiators", "Forms polymers", "Flammable; toxic", "/Resources/Reaction_Images/dienes/polymerization.gif");
        addReaction(dienes, "Claisen Rearrangement", "Heat", "Sigmatropic rearrangement", "High temperature", "/Resources/Reaction_Images/dienes/claisen.gif");
        addReaction(dienes, "Cope Rearrangement", "Heat", "Sigmatropic rearrangement", "High temperature", "/Resources/Reaction_Images/dienes/cope.gif");
        addReaction(dienes, "Electrocyclic Reactions", "Thermal or photochemical", "Ring opening/closure", "Exothermic", "/Resources/Reaction_Images/dienes/electrocyclic.gif");
        reactionMap.put("Reactions of Dienes", dienes);

        /**
         * Aromatics
         */
        List<Reaction> aromatics = new ArrayList<>();
        addReaction(aromatics, "Nitration [HNO3/H2SO4]", "Zeolite catalyzed", "Electrophilic substitution", "Corrosive; exothermic", "/Resources/Reaction_Images/aromatics/nitration.gif");
        addReaction(aromatics, "Chlorination [Cl2 plus catalyst]", "Use Cl2 in water or solid support", "Electrophilic substitution", "Toxic; corrosive", "/Resources/Reaction_Images/aromatics/chlorination.gif");
        addReaction(aromatics, "Bromination [Br2 plus catalyst]", "Use Br2 in water", "Electrophilic substitution", "Toxic; corrosive", "/Resources/Reaction_Images/aromatics/bromination.gif");
        addReaction(aromatics, "Sulfonylation [SO3/H2SO4]", "Use milder acid", "Electrophilic substitution", "Corrosive", "/Resources/Reaction_Images/aromatics/sulfonylation.gif");
        addReaction(aromatics, "Friedel Crafts alkylation [R-X plus catalyst]", "Use solid acid catalysts", "Alkylation", "Corrosive; reactive", "/Resources/Reaction_Images/aromatics/fc_alkylation.gif");
        addReaction(aromatics, "Friedel Crafts acylation [RCOX plus catalyst]", "Use solid acid catalysts", "Acylation", "Corrosive; reactive", "/Resources/Reaction_Images/aromatics/fc_acylation.gif");
        addReaction(aromatics, "Iodination [I2/catalyst]", "Use safer catalyst", "Electrophilic substitution", "Toxic; corrosive", "/Resources/Reaction_Images/aromatics/iodination.gif");
        addReaction(aromatics, "Side chain oxidation [KMnO4]", "Use mild oxidant", "Oxidation of alkyl side chain", "Oxidizer; toxic", "/Resources/Reaction_Images/aromatics/sidechain_oxidation.gif");
        addReaction(aromatics, "Reduction of nitro groups", "Use catalytic hydrogenation", "Forms amines", "Flammable; toxic", "/Resources/Reaction_Images/aromatics/reduction_nitro.gif");
        addReaction(aromatics, "Reduction of aromatic ketones", "Use mild reducing agent", "Forms alcohols", "Reactive", "/Resources/Reaction_Images/aromatics/reduction_ketone.gif");
        addReaction(aromatics, "Side chain bromination", "Use NBS", "Radical bromination", "Oxidizer; toxic", "/Resources/Reaction_Images/aromatics/sidechain_bromination.gif");
        addReaction(aromatics, "Nucleophilic Aromatic Substitution (SNAr)", "Use strong nucleophile", "Substitution reaction", "Corrosive; toxic", "/Resources/Reaction_Images/aromatics/snar.gif");
        addReaction(aromatics, "Aryne Formation (SNAr via arynes)", "Use strong base", "Formation of aryne intermediate", "Corrosive; toxic", "/Resources/Reaction_Images/aromatics/aryne.gif");
        reactionMap.put("Reactions of Aromatics (Arenes)", aromatics);

        /**
         * Aldehydes and Ketones
         */
        List<Reaction> aldehydesKetones = new ArrayList<>();
        addReaction(aldehydesKetones, "Hydrate formation [H2O]", "Use water", "Forms geminal diols", "Corrosive", "/Resources/Reaction_Images/aldehydes_ketones/hydrate.gif");
        addReaction(aldehydesKetones, "Cyanohydrin formation [CN–]", "Use safer cyanide source", "Forms cyanohydrins", "Toxic; cyanide", "/Resources/Reaction_Images/aldehydes_ketones/cyanohydrin.gif");
        addReaction(aldehydesKetones, "Reduction of aldehydes [NaBH4]", "Use aqueous ethanol", "Forms alcohol", "Flammable; reactive", "/Resources/Reaction_Images/aldehydes_ketones/reduction_aldehyde_nabh4.gif");
        addReaction(aldehydesKetones, "Reduction of aldehydes [LiAlH4]", "USE Tetrahydrofuran (THF). THF is less toxic, forms fewer hazardous peroxides, and has safer physical properties like a higher boiling point and lower water misclibility", "Forms alcohol", "Reacts violently with water", "/Resources/Reaction_Images/aldehydes_ketones/reduction_aldehyde_lialh4.gif");
        addReaction(aldehydesKetones, "Reduction of ketones [NaBH4]", "Use aqueous ethanol", "Forms alcohol", "Flammable; reactive", "/Resources/Reaction_Images/aldehydes_ketones/reduction_ketone_nabh4.gif");
        addReaction(aldehydesKetones, "Reduction of ketones [LiAlH4]", "USE Tetrahydrofuran (THF). THF is less toxic, forms fewer hazardous peroxides, and has safer physical properties like a higher boiling point and lower water misclibility", "Forms alcohol", "Reacts violently with water", "/Resources/Reaction_Images/aldehydes_ketones/reduction_ketone_lialh4.gif");
        addReaction(aldehydesKetones, "Grignard addition to aldehydes", "Use RMgX", "Forms alcohols", "Moisture sensitive", "/Resources/Reaction_Images/aldehydes_ketones/grignard_aldehyde.gif");
        addReaction(aldehydesKetones, "Grignard addition to ketones", "Use RMgX", "Forms tertiary alcohols", "Moisture sensitive", "/Resources/Reaction_Images/aldehydes_ketones/grignard_ketone.gif");
        addReaction(aldehydesKetones, "Acetal formation [ROH/H+]", "Acid catalyzed", "Protects carbonyl", "Corrosive", "/Resources/Reaction_Images/aldehydes_ketones/acetal.gif");
        addReaction(aldehydesKetones, "Acetal hydrolysis [H3O+]", "Acid catalyzed", "Removes protection", "Corrosive", "/Resources/Reaction_Images/aldehydes_ketones/acetal_hydrolysis.gif");
        addReaction(aldehydesKetones, "Imine formation [RNH2]", "Acid catalyzed", "Forms imines", "Corrosive", "/Resources/Reaction_Images/aldehydes_ketones/imine.gif");
        addReaction(aldehydesKetones, "Enamine formation [R2NH]", "Acid catalyzed", "Forms enamines", "Corrosive", "/Resources/Reaction_Images/aldehydes_ketones/enamine.gif");
        addReaction(aldehydesKetones, "Wolff-Kishner: reduction to alkanes", "Use hydrazine/KOH", "Reduces carbonyl", "Strong base; toxic", "/Resources/Reaction_Images/aldehydes_ketones/wolff_kishner.gif");
        addReaction(aldehydesKetones, "Clemmensen reduction to alkanes", "Use Zn(Hg)/HCl", "Reduces carbonyl", "Corrosive; toxic", "/Resources/Reaction_Images/aldehydes_ketones/clemmensen.gif");
        addReaction(aldehydesKetones, "Oxidation to carboxylic acid [H2CrO4 or KMnO4]", "Use safer oxidants", "Forms acids", "Toxic; corrosive", "/Resources/Reaction_Images/aldehydes_ketones/oxidation_acid.gif");
        addReaction(aldehydesKetones, "Keto-Enol tautomerism", "Catalyst optional", "Equilibrium between forms", "Mild hazard", "/Resources/Reaction_Images/aldehydes_ketones/keto_enol.gif");
        addReaction(aldehydesKetones, "Enolate formation", "Use base", "Forms enolate nucleophiles", "Strong base; reactive", "/Resources/Reaction_Images/aldehydes_ketones/enolate.gif");
        addReaction(aldehydesKetones, "Aldol addition reaction", "Use base or acid", "Forms β-hydroxy ketone", "Corrosive", "/Resources/Reaction_Images/aldehydes_ketones/aldol_addition.gif");
        addReaction(aldehydesKetones, "Alkylation of enolates", "Use alkyl halides", "Forms substituted ketones", "Corrosive", "/Resources/Reaction_Images/aldehydes_ketones/alkylation_enolate.gif");
        addReaction(aldehydesKetones, "Wittig reaction: alkene formation", "Use phosphonium ylide", "Forms alkenes", "Reactive; toxic", "/Resources/Reaction_Images/aldehydes_ketones/wittig.gif");
        addReaction(aldehydesKetones, "Thioacetal formation", "Use thiols", "Protects carbonyl", "Odorous; corrosive", "/Resources/Reaction_Images/aldehydes_ketones/thioacetal.gif");
        addReaction(aldehydesKetones, "Imine hydrolysis", "Acidic conditions", "Removes imine", "Corrosive", "/Resources/Reaction_Images/aldehydes_ketones/imine_hydrolysis.gif");
        addReaction(aldehydesKetones, "Oxidation to carboxylic acids [Tollens]", "Use Ag(NH3)2+", "Forms acids", "Oxidizer; toxic", "/Resources/Reaction_Images/aldehydes_ketones/tollens.gif");
        addReaction(aldehydesKetones, "Haloform reaction", "Use halogen + base", "Forms carboxylic acids", "Toxic; corrosive", "/Resources/Reaction_Images/aldehydes_ketones/haloform.gif");
        addReaction(aldehydesKetones, "Baeyer-Villiger Reaction", "Use peracid", "Forms esters from ketones", "Oxidizer", "/Resources/Reaction_Images/aldehydes_ketones/baeyer_villiger.gif");
        addReaction(aldehydesKetones, "Aldol Condensation", "Heat and base", "Forms α,β-unsaturated carbonyls", "Corrosive", "/Resources/Reaction_Images/aldehydes_ketones/aldol_condensation.gif");
        addReaction(aldehydesKetones, "Cannizarro Reaction", "Use concentrated base", "Disproportionation", "Corrosive", "/Resources/Reaction_Images/aldehydes_ketones/cannizarro.gif");
        addReaction(aldehydesKetones, "Organolithium Addition To Aldehydes", "Use R-Li", "Forms alcohols", "Reactive; flammable", "/Resources/Reaction_Images/aldehydes_ketones/organolithium_aldehyde.gif");
        addReaction(aldehydesKetones, "Ketone Halogenation", "Use X2 + acid/base", "Alpha halogenation", "Corrosive; toxic", "/Resources/Reaction_Images/aldehydes_ketones/ketone_halogenation.gif");
        reactionMap.put("Reactions of Aldehydes and Ketones", aldehydesKetones);

        /**
         * Carboxylic acids
         */
        List<Reaction> carboxylicAcids = new ArrayList<>();
        addReaction(carboxylicAcids, "Deprotonation [carboxylate formation]", "Use mild base", "Forms carboxylate anions", "Corrosive; basic", "/Resources/Reaction_Images/carboxylic_acids/deprotonation.gif");
        addReaction(carboxylicAcids, "Formation via Grignard and CO2", "Use RMgX + CO2", "Forms acids from Grignard", "Moisture sensitive; reactive", "/Resources/Reaction_Images/carboxylic_acids/grignard_co2.gif");
        addReaction(carboxylicAcids, "Conversion to acid chloride [SOCl2]", "Use SOCl2", "Activates carboxylic acids", "Toxic; corrosive", "/Resources/Reaction_Images/carboxylic_acids/acid_chloride.gif");
        addReaction(carboxylicAcids, "Reduction [LiAlH4]", "Use LiAlH4 in THF", "Forms alcohols", "Reacts violently with water", "/Resources/Reaction_Images/carboxylic_acids/reduction.gif");
        addReaction(carboxylicAcids, "Fischer esterification", "Use alcohol + acid", "Forms esters", "Corrosive; flammable", "/Resources/Reaction_Images/carboxylic_acids/fischer_esterification.gif");
        addReaction(carboxylicAcids, "Decarboxylation [of β-keto acids]", "Heat or base", "Removes CO2", "High temperature", "/Resources/Reaction_Images/carboxylic_acids/decarboxylation.gif");
        addReaction(carboxylicAcids, "Addition of Organolithiums", "Use R-Li", "Forms ketones or alcohols", "Reactive; flammable", "/Resources/Reaction_Images/carboxylic_acids/organolithium.gif");
        reactionMap.put("Reactions of Carboxylic Acids", carboxylicAcids);

        /**
         * Esters
         */
        List<Reaction> esters = new ArrayList<>();
        addReaction(esters, "Reduction to aldehydes [DIBAL-H]", "Use DIBAL-H", "Partial reduction", "Reactive; flammable", "/Resources/Reaction_Images/esters/reduction_aldehyde.gif");
        addReaction(esters, "Reduction to alcohols [LiAlH4]", "Use LiAlH4", "Full reduction", "Reacts violently with water", "/Resources/Reaction_Images/esters/reduction_alcohol.gif");
        addReaction(esters, "Hydrolysis to carboxylic acid [acidic]", "Use aqueous acid", "Forms acids", "Corrosive", "/Resources/Reaction_Images/esters/hydrolysis_acid.gif");
        addReaction(esters, "Hydrolysis to carboxylic acid [basic]", "Use aqueous base", "Forms acids", "Corrosive; basic", "/Resources/Reaction_Images/esters/hydrolysis_base.gif");
        addReaction(esters, "Addition of Grignard reagents to esters", "Use RMgX", "Forms tertiary alcohols", "Moisture sensitive", "/Resources/Reaction_Images/esters/grignard.gif");
        addReaction(esters, "Claisen condensation", "Use base", "Forms β-keto esters", "Strong base; corrosive", "/Resources/Reaction_Images/esters/claisen.gif");
        addReaction(esters, "Transesterification [basic conditions]", "Use alcohol + base", "Exchanges ester groups", "Basic; corrosive", "/Resources/Reaction_Images/esters/transesterification.gif");
        addReaction(esters, "Formation of Amides From Esters", "Use amines", "Forms amides", "Corrosive; toxic", "/Resources/Reaction_Images/esters/amide_formation.gif");
        reactionMap.put("Reactions of Esters", esters);

        /**
         * Alcyl Halides
         */
        List<Reaction> acylHalides = new ArrayList<>();
        addReaction(acylHalides, "Conversion to esters [ROH]", "Use alcohol", "Forms esters", "Corrosive", "/Resources/Reaction_Images/acyl_halides/ester.gif");
        addReaction(acylHalides, "Conversion to carboxylic acids [H2O]", "Use water", "Forms acids", "Corrosive", "/Resources/Reaction_Images/acyl_halides/acid.gif");
        addReaction(acylHalides, "Conversion to anhydrides [RCO2(–)]", "Use carboxylate salts", "Forms anhydrides", "Corrosive", "/Resources/Reaction_Images/acyl_halides/anhydride.gif");
        addReaction(acylHalides, "Conversion to amides [RNH2]", "Use amines", "Forms amides", "Corrosive; toxic", "/Resources/Reaction_Images/acyl_halides/amide.gif");
        addReaction(acylHalides, "Conversion to ketones [Gilman reagents]", "Use R2CuLi", "Forms ketones", "Reactive; toxic", "/Resources/Reaction_Images/acyl_halides/ketone.gif");
        addReaction(acylHalides, "Conversion to aldehydes [LiAlH(OtBu)3]", "Use selective reducing agent", "Forms aldehydes", "Reactive; flammable", "/Resources/Reaction_Images/acyl_halides/aldehyde.gif");
        reactionMap.put("Reactions of Acyl Halides", acylHalides);

        /**
         * A/B Unsaturated Ketones (Enones)
         */
        List<Reaction> enones = new ArrayList<>();
        addReaction(enones, "Michael reaction [conjugate addition of enolates]", "Use soft nucleophiles", "Forms 1,4-addition products", "Corrosive; reactive", "/Resources/Reaction_Images/enones/michael.gif");
        addReaction(enones, "Conjugate addition of Gilman reagents", "Use R2CuLi", "Selective 1,4-addition", "Reactive; toxic", "/Resources/Reaction_Images/enones/gilman.gif");
        addReaction(enones, "Conjugate addition of other nucleophiles", "Use soft nucleophile", "1,4-addition", "Reactive", "/Resources/Reaction_Images/enones/nucleophile.gif");
        reactionMap.put("Reactions of α,β-Unsaturated Ketones", enones);

        /**
         * Amines and Amides
         */
        List<Reaction> aminesAmides = new ArrayList<>();
        addReaction(aminesAmides, "Dehydration of amides to nitriles [P2O5]", "Use P2O5", "Forms nitriles", "Corrosive; toxic", "/Resources/Reaction_Images/amines_amides/dehydration.gif");
        addReaction(aminesAmides, "Hofmann rearrangement", "Use Br2/NaOH", "Forms amines", "Corrosive; toxic", "/Resources/Reaction_Images/amines_amides/hofmann.gif");
        addReaction(aminesAmides, "Gabriel Synthesis of amines", "Use phthalimide", "Forms primary amines", "Toxic", "/Resources/Reaction_Images/amines_amides/gabriel.gif");
        addReaction(aminesAmides, "Reductive Amination", "Use reducing agent", "Forms amines", "Flammable; toxic", "/Resources/Reaction_Images/amines_amides/reductive_amination.gif");
        addReaction(aminesAmides, "Formation of Diazonium Salts", "Use NaNO2/HCl", "Forms diazonium salts", "Explosive; toxic", "/Resources/Reaction_Images/amines_amides/diazonium.gif");
        addReaction(aminesAmides, "Reactions of Diazonium Salts", "Use coupling partners", "Forms azo compounds", "Explosive; toxic", "/Resources/Reaction_Images/amines_amides/diazonium_reactions.gif");
        addReaction(aminesAmides, "Amide Formation Using DCC", "Use DCC", "Coupling reaction", "Toxic; irritant", "/Resources/Reaction_Images/amines_amides/dcc.gif");
        addReaction(aminesAmides, "Amide Formation from Acid Halides", "Use amine", "Forms amides", "Corrosive; toxic", "/Resources/Reaction_Images/amines_amides/acid_halide.gif");
        addReaction(aminesAmides, "Curtius Rearrangement", "Use azide", "Forms isocyanates", "Toxic; reactive", "/Resources/Reaction_Images/amines_amides/curtius.gif");
        addReaction(aminesAmides, "Reduction of Amides with LiAlH4", "Use LiAlH4", "Forms amines", "Reacts violently with water", "/Resources/Reaction_Images/amines_amides/reduction.gif");
        addReaction(aminesAmides, "Amide Hydrolysis With Acid", "Use H3O+", "Forms carboxylic acid and amine", "Corrosive", "/Resources/Reaction_Images/amines_amides/hydrolysis.gif");
        addReaction(aminesAmides, "Amine Protection and Deprotection", "Use Boc or Fmoc groups", "Protects amine", "Reactive", "/Resources/Reaction_Images/amines_amides/protection.gif");
        addReaction(aminesAmides, "Cope Elimination", "Use heat or base", "Forms alkenes", "High temperature; reactive", "/Resources/Reaction_Images/amines_amides/cope.gif");
        reactionMap.put("Reactions of Amines and Amides", aminesAmides);

        /**
         * Nitriles
         */
        List<Reaction> nitriles = new ArrayList<>();
        addReaction(nitriles, "Addition of Grignard reagents to nitriles", "Use RMgX", "Forms ketones after hydrolysis", "Moisture sensitive", "/Resources/Reaction_Images/nitriles/grignard.gif");
        addReaction(nitriles, "Reduction to amines [LiAlH4]", "Use LiAlH4", "Forms primary amines", "Reacts violently with water", "/Resources/Reaction_Images/nitriles/reduction.gif");
        addReaction(nitriles, "Hydrolysis to carboxylic acids", "Use acid or base", "Forms carboxylic acids", "Corrosive", "/Resources/Reaction_Images/nitriles/hydrolysis.gif");
        reactionMap.put("Reactions of Nitriles", nitriles);

    }

    public static Set<String> getCategories() {
        return reactionMap.keySet();
    }

    public static List<String> getReactionsInCategory(String category) {
        List<String> list = new ArrayList<>();
        if (reactionMap.containsKey(category)) {
            for (Reaction r : reactionMap.get(category)) list.add(r.traditional);
        }
        return list;
    }

    /**  
     * Search box suggester
     */
    public String getSuggestion(String category, String reaction) {
        if (!reactionMap.containsKey(category)) return "Category not found.";
        for (Reaction r : reactionMap.get(category)) {
            if (r.traditional.equalsIgnoreCase(reaction) || reaction.equals("[All Reactions]")) {
                return r.toString();
            }
        }
        return "Reaction not found in category.";
    }

    /**  
     * Get image path search 
     */
    public String getImagePath(String category, String reaction) {
        if (!reactionMap.containsKey(category)) return null;
        for (Reaction r : reactionMap.get(category)) {
            if (r.traditional.equalsIgnoreCase(reaction)) return r.getImagePath();
        }
        return null;
    }
}
