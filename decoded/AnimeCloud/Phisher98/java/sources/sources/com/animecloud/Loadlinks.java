package com.animecloud;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AnimeCloud/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/animecloud/Loadlinks;", "", "data", "Lcom/animecloud/LoadlinksData;", "status", "", "<init>", "(Lcom/animecloud/LoadlinksData;J)V", "getData", "()Lcom/animecloud/LoadlinksData;", "getStatus", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AnimeCloud"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Loadlinks {

    @NotNull
    private final LoadlinksData data;
    private final long status;

    public static /* synthetic */ Loadlinks copy$default(Loadlinks loadlinks, LoadlinksData loadlinksData, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            loadlinksData = loadlinks.data;
        }
        if ((i & 2) != 0) {
            j = loadlinks.status;
        }
        return loadlinks.copy(loadlinksData, j);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LoadlinksData getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getStatus() {
        return this.status;
    }

    @NotNull
    public final Loadlinks copy(@NotNull LoadlinksData data, long status) {
        return new Loadlinks(data, status);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Loadlinks)) {
            return false;
        }
        Loadlinks loadlinks = (Loadlinks) other;
        return Intrinsics.areEqual(this.data, loadlinks.data) && this.status == loadlinks.status;
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + Loadlinks$$ExternalSyntheticBackport0.m9m(this.status);
    }

    @NotNull
    public String toString() {
        return "Loadlinks(data=" + this.data + ", status=" + this.status + ')';
    }

    public Loadlinks(@NotNull LoadlinksData data, long status) {
        this.data = data;
        this.status = status;
    }

    @NotNull
    public final LoadlinksData getData() {
        return this.data;
    }

    public final long getStatus() {
        return this.status;
    }
}
