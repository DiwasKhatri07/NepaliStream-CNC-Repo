package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/phisher98/TBPResponse;", "", "streams", "", "Lcom/phisher98/TBPStream;", "cacheMaxAge", "", "staleRevalidate", "staleError", "<init>", "(Ljava/util/List;JJJ)V", "getStreams", "()Ljava/util/List;", "getCacheMaxAge", "()J", "getStaleRevalidate", "getStaleError", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TBPResponse {
    private final long cacheMaxAge;
    private final long staleError;
    private final long staleRevalidate;

    @NotNull
    private final List<TBPStream> streams;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TBPResponse copy$default(TBPResponse tBPResponse, List list, long j, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = tBPResponse.streams;
        }
        if ((i & 2) != 0) {
            j = tBPResponse.cacheMaxAge;
        }
        if ((i & 4) != 0) {
            j2 = tBPResponse.staleRevalidate;
        }
        if ((i & 8) != 0) {
            j3 = tBPResponse.staleError;
        }
        long j4 = j3;
        return tBPResponse.copy(list, j, j2, j4);
    }

    @NotNull
    public final List<TBPStream> component1() {
        return this.streams;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getCacheMaxAge() {
        return this.cacheMaxAge;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getStaleRevalidate() {
        return this.staleRevalidate;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getStaleError() {
        return this.staleError;
    }

    @NotNull
    public final TBPResponse copy(@NotNull List<TBPStream> streams, long cacheMaxAge, long staleRevalidate, long staleError) {
        return new TBPResponse(streams, cacheMaxAge, staleRevalidate, staleError);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TBPResponse)) {
            return false;
        }
        TBPResponse tBPResponse = (TBPResponse) other;
        return Intrinsics.areEqual(this.streams, tBPResponse.streams) && this.cacheMaxAge == tBPResponse.cacheMaxAge && this.staleRevalidate == tBPResponse.staleRevalidate && this.staleError == tBPResponse.staleError;
    }

    public int hashCode() {
        return (((((this.streams.hashCode() * 31) + TBPResponse$$ExternalSyntheticBackport0.m8m(this.cacheMaxAge)) * 31) + TBPResponse$$ExternalSyntheticBackport0.m8m(this.staleRevalidate)) * 31) + TBPResponse$$ExternalSyntheticBackport0.m8m(this.staleError);
    }

    @NotNull
    public String toString() {
        return "TBPResponse(streams=" + this.streams + ", cacheMaxAge=" + this.cacheMaxAge + ", staleRevalidate=" + this.staleRevalidate + ", staleError=" + this.staleError + ')';
    }

    public TBPResponse(@NotNull List<TBPStream> list, long cacheMaxAge, long staleRevalidate, long staleError) {
        this.streams = list;
        this.cacheMaxAge = cacheMaxAge;
        this.staleRevalidate = staleRevalidate;
        this.staleError = staleError;
    }

    @NotNull
    public final List<TBPStream> getStreams() {
        return this.streams;
    }

    public final long getCacheMaxAge() {
        return this.cacheMaxAge;
    }

    public final long getStaleRevalidate() {
        return this.staleRevalidate;
    }

    public final long getStaleError() {
        return this.staleError;
    }
}
