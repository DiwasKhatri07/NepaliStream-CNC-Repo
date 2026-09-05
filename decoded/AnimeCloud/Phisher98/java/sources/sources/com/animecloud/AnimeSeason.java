package com.animecloud;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AnimeCloud/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/animecloud/AnimeSeason;", "", "id", "", "createdAt", "", "updatedAt", "season", "animeId", "animeEpisodes", "", "Lcom/animecloud/AnimeEpisode;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getId", "()J", "getCreatedAt", "()Ljava/lang/String;", "getUpdatedAt", "getSeason", "getAnimeId", "getAnimeEpisodes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "AnimeCloud"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnimeSeason {

    @NotNull
    private final List<AnimeEpisode> animeEpisodes;
    private final long animeId;

    @Nullable
    private final String createdAt;
    private final long id;

    @NotNull
    private final String season;

    @Nullable
    private final String updatedAt;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnimeSeason copy$default(AnimeSeason animeSeason, long j, String str, String str2, String str3, long j2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = animeSeason.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = animeSeason.createdAt;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = animeSeason.updatedAt;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = animeSeason.season;
        }
        return animeSeason.copy(j3, str4, str5, str3, (i & 16) != 0 ? animeSeason.animeId : j2, (i & 32) != 0 ? animeSeason.animeEpisodes : list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSeason() {
        return this.season;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getAnimeId() {
        return this.animeId;
    }

    @NotNull
    public final List<AnimeEpisode> component6() {
        return this.animeEpisodes;
    }

    @NotNull
    public final AnimeSeason copy(long id, @Nullable String createdAt, @Nullable String updatedAt, @NotNull String season, long animeId, @NotNull List<AnimeEpisode> animeEpisodes) {
        return new AnimeSeason(id, createdAt, updatedAt, season, animeId, animeEpisodes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimeSeason)) {
            return false;
        }
        AnimeSeason animeSeason = (AnimeSeason) other;
        return this.id == animeSeason.id && Intrinsics.areEqual(this.createdAt, animeSeason.createdAt) && Intrinsics.areEqual(this.updatedAt, animeSeason.updatedAt) && Intrinsics.areEqual(this.season, animeSeason.season) && this.animeId == animeSeason.animeId && Intrinsics.areEqual(this.animeEpisodes, animeSeason.animeEpisodes);
    }

    public int hashCode() {
        return (((((((((AnimeSeason$$ExternalSyntheticBackport0.m2m(this.id) * 31) + (this.createdAt == null ? 0 : this.createdAt.hashCode())) * 31) + (this.updatedAt != null ? this.updatedAt.hashCode() : 0)) * 31) + this.season.hashCode()) * 31) + AnimeSeason$$ExternalSyntheticBackport0.m2m(this.animeId)) * 31) + this.animeEpisodes.hashCode();
    }

    @NotNull
    public String toString() {
        return "AnimeSeason(id=" + this.id + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", season=" + this.season + ", animeId=" + this.animeId + ", animeEpisodes=" + this.animeEpisodes + ')';
    }

    public AnimeSeason(long id, @Nullable String createdAt, @Nullable String updatedAt, @NotNull String season, long animeId, @NotNull List<AnimeEpisode> list) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.season = season;
        this.animeId = animeId;
        this.animeEpisodes = list;
    }

    public /* synthetic */ AnimeSeason(long j, String str, String str2, String str3, long j2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, str3, j2, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    @NotNull
    public final String getSeason() {
        return this.season;
    }

    public final long getAnimeId() {
        return this.animeId;
    }

    @NotNull
    public final List<AnimeEpisode> getAnimeEpisodes() {
        return this.animeEpisodes;
    }
}
