/*
 * Decompiled with CFR 0.150.
 */
package Models;

import Models.AModels.ASpecialty;
import Models.Factory;
import Models.Room;
import Models.System;
import Models.Turn;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 7, 1}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002\u00a2\u0006\u0002\u0010\u0015J\u001a\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001c\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u00182\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u001b\u0010\u001f\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007H\u0002\u00a2\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u000bH\u0002J\b\u0010$\u001a\u00020\"H\u0002J#\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002\u00a2\u0006\u0002\u0010'JL\u0010(\u001a\u00020\"22\u0010)\u001a.\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001a0+j\b\u0012\u0004\u0012\u00020\u001a`,\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001a0+j\b\u0012\u0004\u0012\u00020\u001a`,0*2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2={"LModels/System;", "", "()V", "DayOfWeek", "", "Days", "availableSpecialties", "", "LModels/AModels/ASpecialty;", "[LModels/AModels/ASpecialty;", "currentTurn", "LModels/Turn;", "rooms", "LModels/Room;", "[LModels/Room;", "roomsAmount", "time", "totalSimTime", "turnTime", "turnsPerDay", "AvailableSpecialties", "()[LModels/AModels/ASpecialty;", "FindAllClassesUsingClassLoader", "", "Ljava/lang/Class;", "packageName", "", "GetClass", "className", "GetCurrentDay", "totalTurnTime", "LeastFullRoom", "([LModels/Room;)LModels/Room;", "PatientArrives", "", "RecapAndStartTurn", "Simulation", "StartTurn", "dayOfWeek", "(I[LModels/AModels/ASpecialty;)LModels/Turn;", "TurnRecapToString", "pair", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "day", "Ljava/time/DayOfWeek;", "Desafio"})
public final class System {
    private final int roomsAmount;
    @NotNull
    private final Room[] rooms;
    private int time;
    private final int turnsPerDay;
    private final int turnTime;
    private final int Days;
    private final int totalSimTime;
    private final int DayOfWeek;
    @NotNull
    private final ASpecialty[] availableSpecialties;
    @NotNull
    private Turn currentTurn;

    public System() {
        this.roomsAmount = 3;
        int n = 0;
        int n2 = this.roomsAmount;
        Room[] arrroom = new Room[n2];
        System system = this;
        while (n < n2) {
            int n3 = n++;
            arrroom[n3] = new Room();
        }
        system.rooms = arrroom;
        this.time = 1;
        this.turnsPerDay = 3;
        this.turnTime = 10;
        this.Days = 7;
        this.totalSimTime = this.Days * this.turnsPerDay * this.turnTime + 1;
        this.DayOfWeek = this.GetCurrentDay(1, this.turnsPerDay * this.turnTime);
        this.availableSpecialties = this.AvailableSpecialties();
        this.currentTurn = this.StartTurn(this.DayOfWeek, this.availableSpecialties);
        for (int i = 0; i < 1001; ++i) {
            this.Simulation();
        }
    }

    private final void Simulation() {
        while (this.time < this.totalSimTime) {
            if (this.time % 2 == 0) {
                this.PatientArrives();
            }
            if (this.time % 4 == 0) {
                this.currentTurn.TreatPatient();
            }
            if (this.time % 10 == 0) {
                this.currentTurn = this.RecapAndStartTurn();
            }
            int n = this.time;
            this.time = n + 1;
        }
    }

    /*
     * WARNING - void declaration
     */
    private final Room LeastFullRoom(Room[] rooms) {
        void $this$mapTo$iv$iv;
        Room leastFull = null;
        Room[] $this$map$iv = rooms;
        boolean $i$f$map = false;
        Room[] arrroom = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        int n = ((void)$this$mapTo$iv$iv).length;
        for (int i = 0; i < n; ++i) {
            void it;
            void item$iv$iv;
            void var11_11 = item$iv$iv = $this$mapTo$iv$iv[i];
            Collection collection = destination$iv$iv;
            boolean bl = false;
            if (leastFull == null) {
                leastFull = it;
            }
            Room room = leastFull;
            Intrinsics.checkNotNull(room);
            if (room.GetAmountPatients() > it.GetAmountPatients()) {
                leastFull = it;
            }
            collection.add(Unit.INSTANCE);
        }
        List cfr_ignored_0 = (List)destination$iv$iv;
        Room room = leastFull;
        Intrinsics.checkNotNull(room);
        return room;
    }

    private final void PatientArrives() {
        Room leastFullRoom = this.LeastFullRoom(this.rooms);
        leastFullRoom.PatientArrives(Factory.INSTANCE.factorySoldier());
    }

    private final Turn StartTurn(int dayOfWeek, ASpecialty[] availableSpecialties) {
        return Factory.INSTANCE.turnFactory(dayOfWeek, availableSpecialties, this.rooms);
    }

    private final ASpecialty[] AvailableSpecialties() {
        ASpecialty[] availableSpecialties = null;
        List si = CollectionsKt.toList((Iterable)this.FindAllClassesUsingClassLoader("Models.Specialties"));
        int n = 0;
        int n2 = si.size();
        ASpecialty[] arraSpecialty = new ASpecialty[n2];
        while (n < n2) {
            int n3 = n++;
            Object t = ((Class)si.get(n3)).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type Models.AModels.ASpecialty");
            arraSpecialty[n3] = (ASpecialty)t;
        }
        availableSpecialties = arraSpecialty;
        return availableSpecialties;
    }

    private final Set<Class<?>> FindAllClassesUsingClassLoader(String packageName) {
        CharSequence charSequence = packageName;
        Object object = new Regex("[.]");
        String string = "/";
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(((Regex)object).replace(charSequence, string));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        object = reader.lines().filter(arg_0 -> System.FindAllClassesUsingClassLoader$lambda$1(FindAllClassesUsingClassLoader.1.INSTANCE, arg_0)).map(arg_0 -> System.FindAllClassesUsingClassLoader$lambda$2(new Function1<String, Class<?>>(this, packageName){
            final /* synthetic */ System this$0;
            final /* synthetic */ String $packageName;
            {
                this.this$0 = $receiver;
                this.$packageName = $packageName;
                super(1);
            }

            public final Class<?> invoke(@NotNull String line) {
                Intrinsics.checkNotNullParameter(line, "line");
                return System.access$GetClass(this.this$0, line, this.$packageName);
            }
        }, arg_0)).collect(Collectors.toSet());
        Intrinsics.checkNotNullExpressionValue(object, "private fun FindAllClass\u2026Collectors.toSet())\n    }");
        return (Set)object;
    }

    private final Class<?> GetClass(String className, String packageName) {
        StringBuilder stringBuilder = new StringBuilder().append(packageName).append('.');
        String string = className.substring(0, StringsKt.lastIndexOf$default((CharSequence)className, '.', 0, false, 6, null));
        Intrinsics.checkNotNullExpressionValue(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        Class<?> class_ = Class.forName(stringBuilder.append(string).toString());
        Intrinsics.checkNotNullExpressionValue(class_, "forName(\n            pac\u2026stIndexOf('.'))\n        )");
        return class_;
    }

    private final int GetCurrentDay(int time, int totalTurnTime) {
        int dayNumber = (int)Math.floor(time / totalTurnTime);
        if (dayNumber == 7) {
            return 7;
        }
        return dayNumber + 1;
    }

    private final void TurnRecapToString(Pair<? extends ArrayList<String>, ? extends ArrayList<String>> pair, DayOfWeek day, int turnTime) {
        String it;
        Collection collection;
        Iterable $this$mapTo$iv$iv;
        String[] arrstring = new String[]{"00:00-08:00", "08:00-16:00", "16:00-00:00"};
        String[] arrayOfTimes = arrstring;
        java.lang.System.out.println((Object)("" + '\n' + day + " turn range: " + arrayOfTimes[turnTime % 3]));
        java.lang.System.out.println((Object)"Treated patients:");
        Iterable $this$map$iv = pair.getFirst();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            String string = (String)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl = false;
            java.lang.System.out.println((Object)it);
            collection.add(Unit.INSTANCE);
        }
        List cfr_ignored_0 = (List)destination$iv$iv;
        java.lang.System.out.println((Object)"Moved patients:");
        $this$map$iv = pair.getSecond();
        $i$f$map = false;
        $this$mapTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            it = (String)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl = false;
            java.lang.System.out.println((Object)it);
            collection.add(Unit.INSTANCE);
        }
        List cfr_ignored_1 = (List)destination$iv$iv;
    }

    private final Turn RecapAndStartTurn() {
        int DayOfWeek2 = this.GetCurrentDay(this.time, this.turnsPerDay * this.turnTime);
        return this.StartTurn(DayOfWeek2, this.availableSpecialties);
    }

    private static final boolean FindAllClassesUsingClassLoader$lambda$1(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter($tmp0, "$tmp0");
        return (Boolean)$tmp0.invoke(p0);
    }

    private static final Class FindAllClassesUsingClassLoader$lambda$2(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter($tmp0, "$tmp0");
        return (Class)$tmp0.invoke(p0);
    }

    public static final /* synthetic */ Class access$GetClass(System $this, String className, String packageName) {
        return $this.GetClass(className, packageName);
    }
}
