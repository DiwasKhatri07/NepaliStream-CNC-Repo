package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0001HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/phisher98/HexaResult;", "", "sources", "", "Lcom/phisher98/HexaSource;", "skipTime", "<init>", "(Ljava/util/List;Ljava/lang/Object;)V", "getSources", "()Ljava/util/List;", "getSkipTime", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class HexaResult {

    @Nullable
    private final Object skipTime;

    @Nullable
    private final List<HexaSource> sources;

    /* JADX WARN: Illegal instructions before constructor call */
    public HexaResult() {
        List list = null;
        this(list, list, 3, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HexaResult copy$default(HexaResult hexaResult, List list, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            list = hexaResult.sources;
        }
        if ((i & 2) != 0) {
            obj = hexaResult.skipTime;
        }
        return hexaResult.copy(list, obj);
    }

    @Nullable
    public final List<HexaSource> component1() {
        return this.sources;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Object getSkipTime() {
        return this.skipTime;
    }

    @NotNull
    public final HexaResult copy(@Nullable List<HexaSource> sources, @Nullable Object skipTime) {
        return new HexaResult(sources, skipTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HexaResult)) {
            return false;
        }
        HexaResult hexaResult = (HexaResult) other;
        return Intrinsics.areEqual(this.sources, hexaResult.sources) && Intrinsics.areEqual(this.skipTime, hexaResult.skipTime);
    }

    public int hashCode() {
        return ((this.sources == null ? 0 : this.sources.hashCode()) * 31) + (this.skipTime != null ? this.skipTime.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "HexaResult(sources=" + this.sources + ", skipTime=" + this.skipTime + ')';
    }

    public HexaResult(@Nullable List<HexaSource> list, @Nullable Object skipTime) {
        this.sources = list;
        this.skipTime = skipTime;
    }

    public /* synthetic */ HexaResult(List list, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : obj);
    }

    @Nullable
    public final List<HexaSource> getSources() {
        return this.sources;
    }

    @Nullable
    public final Object getSkipTime() {
        return this.skipTime;
    }
}
