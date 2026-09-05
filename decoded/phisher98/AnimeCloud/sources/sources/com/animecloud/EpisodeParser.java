package com.animecloud;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/AnimeCloud/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/animecloud/EpisodeParser;", "", "data", "Lcom/animecloud/Data;", "status", "", "<init>", "(Lcom/animecloud/Data;J)V", "getData", "()Lcom/animecloud/Data;", "getStatus", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AnimeCloud"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodeParser {

    @NotNull
    private final Data data;
    private final long status;

    public static /* synthetic */ EpisodeParser copy$default(EpisodeParser episodeParser, Data data, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            data = episodeParser.data;
        }
        if ((i & 2) != 0) {
            j = episodeParser.status;
        }
        return episodeParser.copy(data, j);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Data getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getStatus() {
        return this.status;
    }

    @NotNull
    public final EpisodeParser copy(@NotNull Data data, long status) {
        return new EpisodeParser(data, status);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodeParser)) {
            return false;
        }
        EpisodeParser episodeParser = (EpisodeParser) other;
        return Intrinsics.areEqual(this.data, episodeParser.data) && this.status == episodeParser.status;
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + EpisodeParser$$ExternalSyntheticBackport0.m4m(this.status);
    }

    @NotNull
    public String toString() {
        return "EpisodeParser(data=" + this.data + ", status=" + this.status + ')';
    }

    public EpisodeParser(@NotNull Data data, long status) {
        this.data = data;
        this.status = status;
    }

    @NotNull
    public final Data getData() {
        return this.data;
    }

    public final long getStatus() {
        return this.status;
    }
}
