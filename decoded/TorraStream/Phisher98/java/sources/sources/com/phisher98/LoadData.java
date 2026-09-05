package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/TorraStream/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010JT\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010¨\u0006\""}, d2 = {"Lcom/phisher98/LoadData;", "", "title", "", "year", "", "isAnime", "", "imdbId", "season", "episode", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getTitle", "()Ljava/lang/String;", "getYear", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Z", "getImdbId", "getSeason", "getEpisode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/LoadData;", "equals", "other", "hashCode", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class LoadData {

    @Nullable
    private final Integer episode;

    @Nullable
    private final String imdbId;
    private final boolean isAnime;

    @Nullable
    private final Integer season;

    @Nullable
    private final String title;

    @Nullable
    private final Integer year;

    public LoadData() {
        this(null, null, false, null, null, null, 63, null);
    }

    public static /* synthetic */ LoadData copy$default(LoadData loadData, String str, Integer num, boolean z, String str2, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loadData.title;
        }
        if ((i & 2) != 0) {
            num = loadData.year;
        }
        if ((i & 4) != 0) {
            z = loadData.isAnime;
        }
        if ((i & 8) != 0) {
            str2 = loadData.imdbId;
        }
        if ((i & 16) != 0) {
            num2 = loadData.season;
        }
        if ((i & 32) != 0) {
            num3 = loadData.episode;
        }
        Integer num4 = num2;
        Integer num5 = num3;
        return loadData.copy(str, num, z, str2, num4, num5);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getYear() {
        return this.year;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsAnime() {
        return this.isAnime;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getImdbId() {
        return this.imdbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getSeason() {
        return this.season;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getEpisode() {
        return this.episode;
    }

    @NotNull
    public final LoadData copy(@Nullable String title, @Nullable Integer year, boolean isAnime, @Nullable String imdbId, @Nullable Integer season, @Nullable Integer episode) {
        return new LoadData(title, year, isAnime, imdbId, season, episode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadData)) {
            return false;
        }
        LoadData loadData = (LoadData) other;
        return Intrinsics.areEqual(this.title, loadData.title) && Intrinsics.areEqual(this.year, loadData.year) && this.isAnime == loadData.isAnime && Intrinsics.areEqual(this.imdbId, loadData.imdbId) && Intrinsics.areEqual(this.season, loadData.season) && Intrinsics.areEqual(this.episode, loadData.episode);
    }

    public int hashCode() {
        return ((((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + LoadData$$ExternalSyntheticBackport0.m3m(this.isAnime)) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode != null ? this.episode.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LoadData(title=" + this.title + ", year=" + this.year + ", isAnime=" + this.isAnime + ", imdbId=" + this.imdbId + ", season=" + this.season + ", episode=" + this.episode + ')';
    }

    public LoadData(@Nullable String title, @Nullable Integer year, boolean isAnime, @Nullable String imdbId, @Nullable Integer season, @Nullable Integer episode) {
        this.title = title;
        this.year = year;
        this.isAnime = isAnime;
        this.imdbId = imdbId;
        this.season = season;
        this.episode = episode;
    }

    public /* synthetic */ LoadData(String str, Integer num, boolean z, String str2, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : num3);
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Integer getYear() {
        return this.year;
    }

    public final boolean isAnime() {
        return this.isAnime;
    }

    @Nullable
    public final String getImdbId() {
        return this.imdbId;
    }

    @Nullable
    public final Integer getSeason() {
        return this.season;
    }

    @Nullable
    public final Integer getEpisode() {
        return this.episode;
    }
}
