package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/phisher98/ReAnimeStreamResult;", "", "stream", "", "<init>", "(Ljava/lang/String;)V", "getStream", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ReAnimeStreamResult {

    @NotNull
    private final String stream;

    public static /* synthetic */ ReAnimeStreamResult copy$default(ReAnimeStreamResult reAnimeStreamResult, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reAnimeStreamResult.stream;
        }
        return reAnimeStreamResult.copy(str);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStream() {
        return this.stream;
    }

    @NotNull
    public final ReAnimeStreamResult copy(@NotNull String stream) {
        return new ReAnimeStreamResult(stream);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ReAnimeStreamResult) && Intrinsics.areEqual(this.stream, ((ReAnimeStreamResult) other).stream);
    }

    public int hashCode() {
        return this.stream.hashCode();
    }

    @NotNull
    public String toString() {
        return "ReAnimeStreamResult(stream=" + this.stream + ')';
    }

    public ReAnimeStreamResult(@NotNull String stream) {
        this.stream = stream;
    }

    @NotNull
    public final String getStream() {
        return this.stream;
    }
}
