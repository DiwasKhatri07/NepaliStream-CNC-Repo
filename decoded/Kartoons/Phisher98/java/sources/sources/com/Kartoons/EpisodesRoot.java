package com.Kartoons;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KartoonsParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003JD\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/Kartoons/EpisodesRoot;", "", "success", "", "data", "", "Lcom/Kartoons/EpisodeItem;", "season", "Lcom/Kartoons/EpisodeSeasonMeta;", "show", "Lcom/Kartoons/EpisodeShowMeta;", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;Lcom/Kartoons/EpisodeSeasonMeta;Lcom/Kartoons/EpisodeShowMeta;)V", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getData", "()Ljava/util/List;", "getSeason", "()Lcom/Kartoons/EpisodeSeasonMeta;", "getShow", "()Lcom/Kartoons/EpisodeShowMeta;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/util/List;Lcom/Kartoons/EpisodeSeasonMeta;Lcom/Kartoons/EpisodeShowMeta;)Lcom/Kartoons/EpisodesRoot;", "equals", "other", "hashCode", "", "toString", "", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodesRoot {

    @Nullable
    private final List<EpisodeItem> data;

    @Nullable
    private final EpisodeSeasonMeta season;

    @Nullable
    private final EpisodeShowMeta show;

    @Nullable
    private final Boolean success;

    public EpisodesRoot() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EpisodesRoot copy$default(EpisodesRoot episodesRoot, Boolean bool, List list, EpisodeSeasonMeta episodeSeasonMeta, EpisodeShowMeta episodeShowMeta, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = episodesRoot.success;
        }
        if ((i & 2) != 0) {
            list = episodesRoot.data;
        }
        if ((i & 4) != 0) {
            episodeSeasonMeta = episodesRoot.season;
        }
        if ((i & 8) != 0) {
            episodeShowMeta = episodesRoot.show;
        }
        return episodesRoot.copy(bool, list, episodeSeasonMeta, episodeShowMeta);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    @Nullable
    public final List<EpisodeItem> component2() {
        return this.data;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final EpisodeSeasonMeta getSeason() {
        return this.season;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final EpisodeShowMeta getShow() {
        return this.show;
    }

    @NotNull
    public final EpisodesRoot copy(@Nullable Boolean success, @Nullable List<EpisodeItem> data, @Nullable EpisodeSeasonMeta season, @Nullable EpisodeShowMeta show) {
        return new EpisodesRoot(success, data, season, show);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodesRoot)) {
            return false;
        }
        EpisodesRoot episodesRoot = (EpisodesRoot) other;
        return Intrinsics.areEqual(this.success, episodesRoot.success) && Intrinsics.areEqual(this.data, episodesRoot.data) && Intrinsics.areEqual(this.season, episodesRoot.season) && Intrinsics.areEqual(this.show, episodesRoot.show);
    }

    public int hashCode() {
        return ((((((this.success == null ? 0 : this.success.hashCode()) * 31) + (this.data == null ? 0 : this.data.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.show != null ? this.show.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EpisodesRoot(success=" + this.success + ", data=" + this.data + ", season=" + this.season + ", show=" + this.show + ')';
    }

    public EpisodesRoot(@Nullable Boolean success, @Nullable List<EpisodeItem> list, @Nullable EpisodeSeasonMeta season, @Nullable EpisodeShowMeta show) {
        this.success = success;
        this.data = list;
        this.season = season;
        this.show = show;
    }

    public /* synthetic */ EpisodesRoot(Boolean bool, List list, EpisodeSeasonMeta episodeSeasonMeta, EpisodeShowMeta episodeShowMeta, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : episodeSeasonMeta, (i & 8) != 0 ? null : episodeShowMeta);
    }

    @Nullable
    public final Boolean getSuccess() {
        return this.success;
    }

    @Nullable
    public final List<EpisodeItem> getData() {
        return this.data;
    }

    @Nullable
    public final EpisodeSeasonMeta getSeason() {
        return this.season;
    }

    @Nullable
    public final EpisodeShowMeta getShow() {
        return this.show;
    }
}
