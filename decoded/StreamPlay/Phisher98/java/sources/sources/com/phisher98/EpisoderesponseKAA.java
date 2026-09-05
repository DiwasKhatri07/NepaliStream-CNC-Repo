package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/phisher98/EpisoderesponseKAA;", "", "slug", "", "title", "duration_ms", "", "episode_number", "", "episode_string", "thumbnail", "Lcom/phisher98/ThumbnailKAA;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Number;Ljava/lang/String;Lcom/phisher98/ThumbnailKAA;)V", "getSlug", "()Ljava/lang/String;", "getTitle", "getDuration_ms", "()J", "getEpisode_number", "()Ljava/lang/Number;", "getEpisode_string", "getThumbnail", "()Lcom/phisher98/ThumbnailKAA;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisoderesponseKAA {
    private final long duration_ms;

    @NotNull
    private final Number episode_number;

    @NotNull
    private final String episode_string;

    @NotNull
    private final String slug;

    @NotNull
    private final ThumbnailKAA thumbnail;

    @NotNull
    private final String title;

    public static /* synthetic */ EpisoderesponseKAA copy$default(EpisoderesponseKAA episoderesponseKAA, String str, String str2, long j, Number number, String str3, ThumbnailKAA thumbnailKAA, int i, Object obj) {
        if ((i & 1) != 0) {
            str = episoderesponseKAA.slug;
        }
        if ((i & 2) != 0) {
            str2 = episoderesponseKAA.title;
        }
        if ((i & 4) != 0) {
            j = episoderesponseKAA.duration_ms;
        }
        if ((i & 8) != 0) {
            number = episoderesponseKAA.episode_number;
        }
        if ((i & 16) != 0) {
            str3 = episoderesponseKAA.episode_string;
        }
        if ((i & 32) != 0) {
            thumbnailKAA = episoderesponseKAA.thumbnail;
        }
        ThumbnailKAA thumbnailKAA2 = thumbnailKAA;
        Number number2 = number;
        long j2 = j;
        return episoderesponseKAA.copy(str, str2, j2, number2, str3, thumbnailKAA2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getDuration_ms() {
        return this.duration_ms;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Number getEpisode_number() {
        return this.episode_number;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEpisode_string() {
        return this.episode_string;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ThumbnailKAA getThumbnail() {
        return this.thumbnail;
    }

    @NotNull
    public final EpisoderesponseKAA copy(@NotNull String slug, @NotNull String title, long duration_ms, @NotNull Number episode_number, @NotNull String episode_string, @NotNull ThumbnailKAA thumbnail) {
        return new EpisoderesponseKAA(slug, title, duration_ms, episode_number, episode_string, thumbnail);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisoderesponseKAA)) {
            return false;
        }
        EpisoderesponseKAA episoderesponseKAA = (EpisoderesponseKAA) other;
        return Intrinsics.areEqual(this.slug, episoderesponseKAA.slug) && Intrinsics.areEqual(this.title, episoderesponseKAA.title) && this.duration_ms == episoderesponseKAA.duration_ms && Intrinsics.areEqual(this.episode_number, episoderesponseKAA.episode_number) && Intrinsics.areEqual(this.episode_string, episoderesponseKAA.episode_string) && Intrinsics.areEqual(this.thumbnail, episoderesponseKAA.thumbnail);
    }

    public int hashCode() {
        return (((((((((this.slug.hashCode() * 31) + this.title.hashCode()) * 31) + EpisoderesponseKAA$$ExternalSyntheticBackport0.m16m(this.duration_ms)) * 31) + this.episode_number.hashCode()) * 31) + this.episode_string.hashCode()) * 31) + this.thumbnail.hashCode();
    }

    @NotNull
    public String toString() {
        return "EpisoderesponseKAA(slug=" + this.slug + ", title=" + this.title + ", duration_ms=" + this.duration_ms + ", episode_number=" + this.episode_number + ", episode_string=" + this.episode_string + ", thumbnail=" + this.thumbnail + ')';
    }

    public EpisoderesponseKAA(@NotNull String slug, @NotNull String title, long duration_ms, @NotNull Number episode_number, @NotNull String episode_string, @NotNull ThumbnailKAA thumbnail) {
        this.slug = slug;
        this.title = title;
        this.duration_ms = duration_ms;
        this.episode_number = episode_number;
        this.episode_string = episode_string;
        this.thumbnail = thumbnail;
    }

    @NotNull
    public final String getSlug() {
        return this.slug;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final long getDuration_ms() {
        return this.duration_ms;
    }

    @NotNull
    public final Number getEpisode_number() {
        return this.episode_number;
    }

    @NotNull
    public final String getEpisode_string() {
        return this.episode_string;
    }

    @NotNull
    public final ThumbnailKAA getThumbnail() {
        return this.thumbnail;
    }
}
