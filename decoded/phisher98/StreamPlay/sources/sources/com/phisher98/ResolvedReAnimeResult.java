package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/ResolvedReAnimeResult;", "", "token", "", "state", "Lcom/phisher98/ResolvedReAnimeState;", "<init>", "(Ljava/lang/String;Lcom/phisher98/ResolvedReAnimeState;)V", "getToken", "()Ljava/lang/String;", "getState", "()Lcom/phisher98/ResolvedReAnimeState;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ResolvedReAnimeResult {

    @NotNull
    private final ResolvedReAnimeState state;

    @NotNull
    private final String token;

    public static /* synthetic */ ResolvedReAnimeResult copy$default(ResolvedReAnimeResult resolvedReAnimeResult, String str, ResolvedReAnimeState resolvedReAnimeState, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resolvedReAnimeResult.token;
        }
        if ((i & 2) != 0) {
            resolvedReAnimeState = resolvedReAnimeResult.state;
        }
        return resolvedReAnimeResult.copy(str, resolvedReAnimeState);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ResolvedReAnimeState getState() {
        return this.state;
    }

    @NotNull
    public final ResolvedReAnimeResult copy(@NotNull String token, @NotNull ResolvedReAnimeState state) {
        return new ResolvedReAnimeResult(token, state);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResolvedReAnimeResult)) {
            return false;
        }
        ResolvedReAnimeResult resolvedReAnimeResult = (ResolvedReAnimeResult) other;
        return Intrinsics.areEqual(this.token, resolvedReAnimeResult.token) && Intrinsics.areEqual(this.state, resolvedReAnimeResult.state);
    }

    public int hashCode() {
        return (this.token.hashCode() * 31) + this.state.hashCode();
    }

    @NotNull
    public String toString() {
        return "ResolvedReAnimeResult(token=" + this.token + ", state=" + this.state + ')';
    }

    public ResolvedReAnimeResult(@NotNull String token, @NotNull ResolvedReAnimeState state) {
        this.token = token;
        this.state = state;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    @NotNull
    public final ResolvedReAnimeState getState() {
        return this.state;
    }
}
