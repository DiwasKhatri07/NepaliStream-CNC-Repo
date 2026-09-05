package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0003HÆ\u0003J3\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/phisher98/FsonicFile;", "", "sources", "", "Lcom/phisher98/FsonicItem;", "alternatives", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getSources", "()Ljava/util/List;", "getAlternatives", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class FsonicFile {

    @Nullable
    private final List<List<FsonicItem>> alternatives;

    @Nullable
    private final List<FsonicItem> sources;

    /* JADX WARN: Illegal instructions before constructor call */
    public FsonicFile() {
        List list = null;
        this(list, list, 3, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FsonicFile copy$default(FsonicFile fsonicFile, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = fsonicFile.sources;
        }
        if ((i & 2) != 0) {
            list2 = fsonicFile.alternatives;
        }
        return fsonicFile.copy(list, list2);
    }

    @Nullable
    public final List<FsonicItem> component1() {
        return this.sources;
    }

    @Nullable
    public final List<List<FsonicItem>> component2() {
        return this.alternatives;
    }

    @NotNull
    public final FsonicFile copy(@Nullable List<FsonicItem> sources, @Nullable List<? extends List<FsonicItem>> alternatives) {
        return new FsonicFile(sources, alternatives);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FsonicFile)) {
            return false;
        }
        FsonicFile fsonicFile = (FsonicFile) other;
        return Intrinsics.areEqual(this.sources, fsonicFile.sources) && Intrinsics.areEqual(this.alternatives, fsonicFile.alternatives);
    }

    public int hashCode() {
        return ((this.sources == null ? 0 : this.sources.hashCode()) * 31) + (this.alternatives != null ? this.alternatives.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FsonicFile(sources=" + this.sources + ", alternatives=" + this.alternatives + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FsonicFile(@Nullable List<FsonicItem> list, @Nullable List<? extends List<FsonicItem>> list2) {
        this.sources = list;
        this.alternatives = list2;
    }

    public /* synthetic */ FsonicFile(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }

    @Nullable
    public final List<FsonicItem> getSources() {
        return this.sources;
    }

    @Nullable
    public final List<List<FsonicItem>> getAlternatives() {
        return this.alternatives;
    }
}
