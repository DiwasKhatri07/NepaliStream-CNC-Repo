package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J,\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/VegamoviesResponse;", "", "found", "", "hits", "", "Lcom/phisher98/VegamoviesHit;", "<init>", "(Ljava/lang/Integer;Ljava/util/List;)V", "getFound", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHits", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/List;)Lcom/phisher98/VegamoviesResponse;", "equals", "", "other", "hashCode", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class VegamoviesResponse {

    @Nullable
    private final Integer found;

    @Nullable
    private final List<VegamoviesHit> hits;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VegamoviesResponse copy$default(VegamoviesResponse vegamoviesResponse, Integer num, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = vegamoviesResponse.found;
        }
        if ((i & 2) != 0) {
            list = vegamoviesResponse.hits;
        }
        return vegamoviesResponse.copy(num, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getFound() {
        return this.found;
    }

    @Nullable
    public final List<VegamoviesHit> component2() {
        return this.hits;
    }

    @NotNull
    public final VegamoviesResponse copy(@Nullable Integer found, @Nullable List<VegamoviesHit> hits) {
        return new VegamoviesResponse(found, hits);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VegamoviesResponse)) {
            return false;
        }
        VegamoviesResponse vegamoviesResponse = (VegamoviesResponse) other;
        return Intrinsics.areEqual(this.found, vegamoviesResponse.found) && Intrinsics.areEqual(this.hits, vegamoviesResponse.hits);
    }

    public int hashCode() {
        return ((this.found == null ? 0 : this.found.hashCode()) * 31) + (this.hits != null ? this.hits.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VegamoviesResponse(found=" + this.found + ", hits=" + this.hits + ')';
    }

    public VegamoviesResponse(@Nullable Integer found, @Nullable List<VegamoviesHit> list) {
        this.found = found;
        this.hits = list;
    }

    @Nullable
    public final Integer getFound() {
        return this.found;
    }

    @Nullable
    public final List<VegamoviesHit> getHits() {
        return this.hits;
    }
}
