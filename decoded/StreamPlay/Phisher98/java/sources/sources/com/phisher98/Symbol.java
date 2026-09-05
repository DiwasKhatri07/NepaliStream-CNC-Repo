package com.phisher98;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/phisher98/Symbol;", "", "decimalValue", "", "<init>", "(Ljava/lang/String;II)V", "getDecimalValue", "()I", "I", "IV", "V", "IX", "X", "Companion", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
enum Symbol {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10);

    private final int decimalValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static EnumEntries<Symbol> getEntries() {
        return $ENTRIES;
    }

    Symbol(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    public final int getDecimalValue() {
        return this.decimalValue;
    }

    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/phisher98/Symbol$Companion;", "", "<init>", "()V", "closestBelow", "Lcom/phisher98/Symbol;", "value", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/Symbol$Companion\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n37#2,2:2266\n7773#3:2268\n296#4,2:2269\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/Symbol$Companion\n*L\n429#1:2266,2\n430#1:2268\n431#1:2269,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Symbol closestBelow(int value) {
            Object element$iv;
            Collection $this$toTypedArray$iv = Symbol.getEntries();
            Object[] $this$sortedByDescending$iv = $this$toTypedArray$iv.toArray(new Symbol[0]);
            Iterable $this$firstOrNull$iv = ArraysKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: com.phisher98.Symbol$Companion$closestBelow$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Symbol it = (Symbol) t2;
                    Symbol it2 = (Symbol) t;
                    return ComparisonsKt.compareValues(Integer.valueOf(it.getDecimalValue()), Integer.valueOf(it2.getDecimalValue()));
                }
            });
            Iterator it = $this$firstOrNull$iv.iterator();
            while (it.hasNext()) {
                element$iv = it.next();
                Symbol it2 = (Symbol) element$iv;
                if (value >= it2.getDecimalValue()) {
                    return (Symbol) element$iv;
                }
            }
            element$iv = null;
            return (Symbol) element$iv;
        }
    }
}
