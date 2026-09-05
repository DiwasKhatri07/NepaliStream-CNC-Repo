package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/phisher98/ReAnime;", "", "success", "", "servers", "", "Lcom/phisher98/ReAnimeServer;", "<init>", "(ZLjava/util/List;)V", "getSuccess", "()Z", "getServers", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ReAnime {

    @NotNull
    private final List<ReAnimeServer> servers;
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReAnime copy$default(ReAnime reAnime, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = reAnime.success;
        }
        if ((i & 2) != 0) {
            list = reAnime.servers;
        }
        return reAnime.copy(z, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    @NotNull
    public final List<ReAnimeServer> component2() {
        return this.servers;
    }

    @NotNull
    public final ReAnime copy(boolean success, @NotNull List<ReAnimeServer> servers) {
        return new ReAnime(success, servers);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReAnime)) {
            return false;
        }
        ReAnime reAnime = (ReAnime) other;
        return this.success == reAnime.success && Intrinsics.areEqual(this.servers, reAnime.servers);
    }

    public int hashCode() {
        return (ReAnime$$ExternalSyntheticBackport0.m19m(this.success) * 31) + this.servers.hashCode();
    }

    @NotNull
    public String toString() {
        return "ReAnime(success=" + this.success + ", servers=" + this.servers + ')';
    }

    public ReAnime(boolean success, @NotNull List<ReAnimeServer> list) {
        this.success = success;
        this.servers = list;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    @NotNull
    public final List<ReAnimeServer> getServers() {
        return this.servers;
    }
}
