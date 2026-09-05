package com.idlix;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IdlixParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IdlixProvider/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010!\u001a\u0004\u0018\u00010\u0001HÆ\u0003Jn\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010'\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010(\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/idlix/Episode;", "", "id", "", "episodeNumber", "", "name", "overview", "stillPath", "airDate", "runtime", "voteAverage", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;)V", "getId", "()Ljava/lang/String;", "getEpisodeNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "getOverview", "getStillPath", "getAirDate", "getRuntime", "getVoteAverage", "()Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;)Lcom/idlix/Episode;", "equals", "", "other", "hashCode", "toString", "IdlixProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Episode {

    @Nullable
    private final String airDate;

    @Nullable
    private final Integer episodeNumber;

    @Nullable
    private final String id;

    @Nullable
    private final String name;

    @Nullable
    private final String overview;

    @Nullable
    private final Integer runtime;

    @Nullable
    private final String stillPath;

    @Nullable
    private final Object voteAverage;

    public Episode() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ Episode copy$default(Episode episode, String str, Integer num, String str2, String str3, String str4, String str5, Integer num2, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = episode.id;
        }
        if ((i & 2) != 0) {
            num = episode.episodeNumber;
        }
        if ((i & 4) != 0) {
            str2 = episode.name;
        }
        if ((i & 8) != 0) {
            str3 = episode.overview;
        }
        if ((i & 16) != 0) {
            str4 = episode.stillPath;
        }
        if ((i & 32) != 0) {
            str5 = episode.airDate;
        }
        if ((i & 64) != 0) {
            num2 = episode.runtime;
        }
        if ((i & 128) != 0) {
            obj = episode.voteAverage;
        }
        Integer num3 = num2;
        Object obj3 = obj;
        String str6 = str4;
        String str7 = str5;
        return episode.copy(str, num, str2, str3, str6, str7, num3, obj3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getEpisodeNumber() {
        return this.episodeNumber;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStillPath() {
        return this.stillPath;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAirDate() {
        return this.airDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getRuntime() {
        return this.runtime;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Object getVoteAverage() {
        return this.voteAverage;
    }

    @NotNull
    public final Episode copy(@Nullable String id, @Nullable Integer episodeNumber, @Nullable String name, @Nullable String overview, @Nullable String stillPath, @Nullable String airDate, @Nullable Integer runtime, @Nullable Object voteAverage) {
        return new Episode(id, episodeNumber, name, overview, stillPath, airDate, runtime, voteAverage);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Episode)) {
            return false;
        }
        Episode episode = (Episode) other;
        return Intrinsics.areEqual(this.id, episode.id) && Intrinsics.areEqual(this.episodeNumber, episode.episodeNumber) && Intrinsics.areEqual(this.name, episode.name) && Intrinsics.areEqual(this.overview, episode.overview) && Intrinsics.areEqual(this.stillPath, episode.stillPath) && Intrinsics.areEqual(this.airDate, episode.airDate) && Intrinsics.areEqual(this.runtime, episode.runtime) && Intrinsics.areEqual(this.voteAverage, episode.voteAverage);
    }

    public int hashCode() {
        return ((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.episodeNumber == null ? 0 : this.episodeNumber.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.stillPath == null ? 0 : this.stillPath.hashCode())) * 31) + (this.airDate == null ? 0 : this.airDate.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.voteAverage != null ? this.voteAverage.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Episode(id=" + this.id + ", episodeNumber=" + this.episodeNumber + ", name=" + this.name + ", overview=" + this.overview + ", stillPath=" + this.stillPath + ", airDate=" + this.airDate + ", runtime=" + this.runtime + ", voteAverage=" + this.voteAverage + ')';
    }

    public Episode(@Nullable String id, @Nullable Integer episodeNumber, @Nullable String name, @Nullable String overview, @Nullable String stillPath, @Nullable String airDate, @Nullable Integer runtime, @Nullable Object voteAverage) {
        this.id = id;
        this.episodeNumber = episodeNumber;
        this.name = name;
        this.overview = overview;
        this.stillPath = stillPath;
        this.airDate = airDate;
        this.runtime = runtime;
        this.voteAverage = voteAverage;
    }

    public /* synthetic */ Episode(String str, Integer num, String str2, String str3, String str4, String str5, Integer num2, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : num2, (i & 128) != 0 ? null : obj);
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final Integer getEpisodeNumber() {
        return this.episodeNumber;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    public final String getStillPath() {
        return this.stillPath;
    }

    @Nullable
    public final String getAirDate() {
        return this.airDate;
    }

    @Nullable
    public final Integer getRuntime() {
        return this.runtime;
    }

    @Nullable
    public final Object getVoteAverage() {
        return this.voteAverage;
    }
}
