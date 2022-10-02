/*
 * Decompiled with CFR 0.150.
 */
package Models;

import Models.AModels.ASpecialty;
import Models.Factory;
import Models.People.Medic;
import Models.People.Patient;
import Models.Room;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 7, 1}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u00a2\u0006\u0002\u0010\nJ\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020\u0015J\b\u0010\"\u001a\u00020\tH\u0002J\u0010\u0010#\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0006\u0010$\u001a\u00020 J\u0018\u0010%\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J2\u0010'\u001a.\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e0(R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\fj\b\u0012\u0004\u0012\u00020\u0011`\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\n\n\u0002\b\u0018\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006*"}, d2={"LModels/Turn;", "", "turnNumber", "", "turnDay", "specialties", "", "LModels/AModels/ASpecialty;", "rooms", "LModels/Room;", "(II[LModels/AModels/ASpecialty;[LModels/Room;)V", "attendedPatients", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "howManyDoctorsOfEach", "medics", "LModels/People/Medic;", "movedPatients", "[LModels/Room;", "[LModels/AModels/ASpecialty;", "Ljava/time/DayOfWeek;", "getTurnNumber", "()I", "turnNumber$1", "ChoosePatient", "LModels/People/Patient;", "CompanyCompatibility", "", "patient", "medic", "EnrollMedics", "", "GetDay", "MostFullRoom", "MovePatient", "TreatPatient", "Treatment", "TreatmentAvailability", "TurnRecap", "Lkotlin/Pair;", "Companion", "Desafio"})
public final class Turn {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int turnNumber$1;
    @NotNull
    private ASpecialty[] specialties;
    @NotNull
    private final Room[] rooms;
    @NotNull
    private final ArrayList<Medic> medics;
    @NotNull
    private final DayOfWeek turnDay;
    private final int howManyDoctorsOfEach;
    @NotNull
    private ArrayList<String> attendedPatients;
    @NotNull
    private ArrayList<String> movedPatients;
    private static int turnNumber;

    public Turn(int turnNumber, int turnDay, @NotNull ASpecialty[] specialties, @NotNull Room[] rooms) {
        Intrinsics.checkNotNullParameter(specialties, "specialties");
        Intrinsics.checkNotNullParameter(rooms, "rooms");
        this.turnNumber$1 = turnNumber;
        this.specialties = specialties;
        this.rooms = rooms;
        this.medics = new ArrayList();
        DayOfWeek dayOfWeek = DayOfWeek.of(turnDay);
        Intrinsics.checkNotNullExpressionValue(dayOfWeek, "of(turnDay)");
        this.turnDay = dayOfWeek;
        this.howManyDoctorsOfEach = 2;
        this.attendedPatients = new ArrayList();
        this.movedPatients = new ArrayList();
        Companion.Increment();
        this.EnrollMedics();
    }

    public final int getTurnNumber() {
        return this.turnNumber$1;
    }

    public final void TreatPatient() {
        Medic medic;
        Medic medic2;
        Patient patient;
        Patient patient2 = patient = this.ChoosePatient();
        if (patient2 != null) {
            Patient it = patient2;
            boolean bl = false;
            medic2 = this.TreatmentAvailability(it);
        } else {
            medic2 = medic = null;
        }
        if (medic != null) {
            boolean canAttend = this.CompanyCompatibility(patient, medic);
            if (canAttend) {
                this.Treatment(patient, medic);
                return;
            }
            this.MovePatient(patient);
            return;
        }
        if (patient != null) {
            this.MovePatient(patient);
        }
    }

    /*
     * WARNING - void declaration
     */
    private final boolean CompanyCompatibility(Patient patient, Medic medic) {
        if (patient != null) {
            void $this$mapTo$iv$iv;
            String[] $this$map$iv = medic.getCompany();
            boolean $i$f$map = false;
            String[] arrstring = $this$map$iv;
            Collection destination$iv$iv = new ArrayList($this$map$iv.length);
            boolean $i$f$mapTo = false;
            int n = ((void)$this$mapTo$iv$iv).length;
            for (int i = 0; i < n; ++i) {
                void medicCompany;
                void item$iv$iv;
                void var11_11 = item$iv$iv = $this$mapTo$iv$iv[i];
                Collection collection = destination$iv$iv;
                boolean bl = false;
                if (Intrinsics.areEqual(medicCompany, patient.getInsurance())) {
                    return true;
                }
                collection.add(Unit.INSTANCE);
            }
            List cfr_ignored_0 = (List)destination$iv$iv;
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    private final Medic TreatmentAvailability(Patient patient) {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = this.medics;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void $this$mapTo$iv$iv2;
            void medic;
            Medic medic2 = (Medic)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            Iterable $this$map$iv2 = medic.getSpecialty().getCanAttend();
            boolean $i$f$map2 = false;
            Iterable iterable2 = $this$map$iv2;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            boolean $i$f$mapTo2 = false;
            for (Object item$iv$iv2 : $this$mapTo$iv$iv2) {
                void provides;
                String string = (String)item$iv$iv2;
                Collection collection2 = destination$iv$iv2;
                boolean bl2 = false;
                if (Intrinsics.areEqual(patient.getAttention(), provides)) {
                    return medic;
                }
                collection2.add(Unit.INSTANCE);
            }
            collection.add((List)destination$iv$iv2);
        }
        List cfr_ignored_0 = (List)destination$iv$iv;
        return null;
    }

    private final Patient ChoosePatient() {
        Patient patient = this.MostFullRoom().PattientIsBeingAttended();
        if (patient != null) {
            return patient;
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    private final Room MostFullRoom() {
        void $this$mapTo$iv$iv;
        Room mostFullRoom = null;
        mostFullRoom = this.rooms[0];
        Room[] $this$map$iv = this.rooms;
        boolean $i$f$map = false;
        Room[] arrroom = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        int n = ((void)$this$mapTo$iv$iv).length;
        for (int i = 0; i < n; ++i) {
            void it;
            void item$iv$iv;
            void var10_10 = item$iv$iv = $this$mapTo$iv$iv[i];
            Collection collection = destination$iv$iv;
            boolean bl = false;
            if (mostFullRoom.GetAmountPatients() < it.GetAmountPatients()) {
                mostFullRoom = it;
            }
            collection.add(Unit.INSTANCE);
        }
        List cfr_ignored_0 = (List)destination$iv$iv;
        return mostFullRoom;
    }

    private final void MovePatient(Patient patient) {
        String stringToAdd = "Patient " + patient.getName() + " with NIDI " + patient.getNIDI() + ", Insurance " + patient.getInsurance() + " attended on " + this.turnDay + " with clear symptoms of " + patient.getAttention() + " could not be attended at Nebulon-B Frigate for lacking of staff/insurance";
        this.movedPatients.add(stringToAdd);
    }

    private final void Treatment(Patient patient, Medic medic) {
        String stringToAdd = "Patient " + patient.getName() + " with NIDI " + patient.getNIDI() + ", Insurance " + patient.getInsurance() + " attended on " + this.turnDay + " with clear symptoms of " + patient.getAttention() + " was attended at Nebulon-B Frigate by " + medic.getName() + " with NIDI " + medic.getNIDI();
        this.attendedPatients.add(stringToAdd);
    }

    @NotNull
    public final Pair<ArrayList<String>, ArrayList<String>> TurnRecap() {
        return new Pair<ArrayList<String>, ArrayList<String>>(this.attendedPatients, this.movedPatients);
    }

    @NotNull
    public final DayOfWeek GetDay() {
        return this.turnDay;
    }

    /*
     * WARNING - void declaration
     */
    private final void EnrollMedics() {
        void $this$mapTo$iv$iv;
        int specialtySize = 0;
        specialtySize = this.specialties.length;
        int amount = specialtySize * this.howManyDoctorsOfEach;
        Iterable $this$map$iv = new IntRange(1, amount);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void i;
            int item$iv$iv;
            int n = item$iv$iv = ((IntIterator)iterator2).nextInt();
            Collection collection = destination$iv$iv;
            boolean bl = false;
            ASpecialty specialty = this.specialties[i % specialtySize];
            collection.add(this.medics.add(Factory.INSTANCE.factoryMedic(specialty)));
        }
        List cfr_ignored_0 = (List)destination$iv$iv;
    }

    @Metadata(mv={1, 7, 1}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"LModels/Turn$Companion;", "", "()V", "turnNumber", "", "getTurnNumber", "()I", "setTurnNumber", "(I)V", "Increment", "", "Desafio"})
    public static final class Companion {
        private Companion() {
        }

        public final int getTurnNumber() {
            return turnNumber;
        }

        public final void setTurnNumber(int n) {
            turnNumber = n;
        }

        public final void Increment() {
            int n = this.getTurnNumber();
            this.setTurnNumber(n + 1);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}
