package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StremioX/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/Credits;", "", "cast", "Ljava/util/ArrayList;", "Lcom/phisher98/Cast;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getCast", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Credits {

    @Nullable
    private final ArrayList<Cast> cast;

    /* JADX WARN: Illegal instructions before constructor call */
    public Credits() {
        ArrayList arrayList = null;
        this(arrayList, 1, arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Credits copy$default(Credits credits, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = credits.cast;
        }
        return credits.copy(arrayList);
    }

    @Nullable
    public final ArrayList<Cast> component1() {
        return this.cast;
    }

    @NotNull
    public final Credits copy(@JsonProperty("cast") @Nullable ArrayList<Cast> cast) {
        return new Credits(cast);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Credits) && Intrinsics.areEqual(this.cast, ((Credits) other).cast);
    }

    public int hashCode() {
        if (this.cast == null) {
            return 0;
        }
        return this.cast.hashCode();
    }

    @NotNull
    public String toString() {
        return "Credits(cast=" + this.cast + ')';
    }

    public Credits(@JsonProperty("cast") @Nullable ArrayList<Cast> arrayList) {
        this.cast = arrayList;
    }

    public /* synthetic */ Credits(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    @Nullable
    public final ArrayList<Cast> getCast() {
        return this.cast;
    }
}
