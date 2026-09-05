package com.animecloud;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/AnimeCloud/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003JW\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006$"}, d2 = {"Lcom/animecloud/AnimeEpisode;", "", "id", "", "createdAt", "", "updatedAt", "episode", "image", "animeSeasonId", "lastSync", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getId", "()J", "getCreatedAt", "()Ljava/lang/String;", "getUpdatedAt", "getEpisode", "getImage", "getAnimeSeasonId", "getLastSync", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "AnimeCloud"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnimeEpisode {
    private final long animeSeasonId;

    @Nullable
    private final String createdAt;

    @NotNull
    private final String episode;
    private final long id;

    @Nullable
    private final String image;

    @Nullable
    private final String lastSync;

    @Nullable
    private final String updatedAt;

    public static /* synthetic */ AnimeEpisode copy$default(AnimeEpisode animeEpisode, long j, String str, String str2, String str3, String str4, long j2, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            j = animeEpisode.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = animeEpisode.createdAt;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = animeEpisode.updatedAt;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = animeEpisode.episode;
        }
        return animeEpisode.copy(j3, str6, str7, str3, (i & 16) != 0 ? animeEpisode.image : str4, (i & 32) != 0 ? animeEpisode.animeSeasonId : j2, (i & 64) != 0 ? animeEpisode.lastSync : str5);
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
    public final String getEpisode() {
        return this.episode;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getAnimeSeasonId() {
        return this.animeSeasonId;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLastSync() {
        return this.lastSync;
    }

    @NotNull
    public final AnimeEpisode copy(long id, @Nullable String createdAt, @Nullable String updatedAt, @NotNull String episode, @Nullable String image, long animeSeasonId, @Nullable String lastSync) {
        return new AnimeEpisode(id, createdAt, updatedAt, episode, image, animeSeasonId, lastSync);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimeEpisode)) {
            return false;
        }
        AnimeEpisode animeEpisode = (AnimeEpisode) other;
        return this.id == animeEpisode.id && Intrinsics.areEqual(this.createdAt, animeEpisode.createdAt) && Intrinsics.areEqual(this.updatedAt, animeEpisode.updatedAt) && Intrinsics.areEqual(this.episode, animeEpisode.episode) && Intrinsics.areEqual(this.image, animeEpisode.image) && this.animeSeasonId == animeEpisode.animeSeasonId && Intrinsics.areEqual(this.lastSync, animeEpisode.lastSync);
    }

    public int hashCode() {
        return (((((((((((AnimeEpisode$$ExternalSyntheticBackport0.m0m(this.id) * 31) + (this.createdAt == null ? 0 : this.createdAt.hashCode())) * 31) + (this.updatedAt == null ? 0 : this.updatedAt.hashCode())) * 31) + this.episode.hashCode()) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + AnimeEpisode$$ExternalSyntheticBackport0.m0m(this.animeSeasonId)) * 31) + (this.lastSync != null ? this.lastSync.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AnimeEpisode(id=" + this.id + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", episode=" + this.episode + ", image=" + this.image + ", animeSeasonId=" + this.animeSeasonId + ", lastSync=" + this.lastSync + ')';
    }

    public AnimeEpisode(long id, @Nullable String createdAt, @Nullable String updatedAt, @NotNull String episode, @Nullable String image, long animeSeasonId, @Nullable String lastSync) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.episode = episode;
        this.image = image;
        this.animeSeasonId = animeSeasonId;
        this.lastSync = lastSync;
    }

    public /* synthetic */ AnimeEpisode(long j, String str, String str2, String str3, String str4, long j2, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, str3, (i & 16) != 0 ? null : str4, j2, (i & 64) != 0 ? null : str5);
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
    public final String getEpisode() {
        return this.episode;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    public final long getAnimeSeasonId() {
        return this.animeSeasonId;
    }

    @Nullable
    public final String getLastSync() {
        return this.lastSync;
    }
}
