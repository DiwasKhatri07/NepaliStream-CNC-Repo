package com.DoraBash;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DoraBashParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/DoraBash/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0082\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010,J\u0014\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001a\u000201HÖ\u0081\u0004J\n\u00102\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012¨\u00063"}, d2 = {"Lcom/DoraBash/Episode;", "", "number", "", "thumbnail", "title", "duration", "released", "tmdb_fetch_episode", "", "id", "type", "url", "post_title", "meta_number", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNumber", "()Ljava/lang/String;", "getThumbnail", "getTitle", "getDuration", "getReleased", "getTmdb_fetch_episode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getId", "()J", "getType", "getUrl", "getPost_title", "getMeta_number", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/DoraBash/Episode;", "equals", "", "other", "hashCode", "", "toString", "DoraBash"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Episode {

    @NotNull
    private final String duration;
    private final long id;

    @Nullable
    private final String meta_number;

    @NotNull
    private final String number;

    @Nullable
    private final String post_title;

    @NotNull
    private final String released;

    @NotNull
    private final String thumbnail;

    @NotNull
    private final String title;

    @Nullable
    private final Long tmdb_fetch_episode;

    @NotNull
    private final String type;

    @NotNull
    private final String url;

    public static /* synthetic */ Episode copy$default(Episode episode, String str, String str2, String str3, String str4, String str5, Long l, long j, String str6, String str7, String str8, String str9, int i, Object obj) {
        if ((i & 1) != 0) {
            str = episode.number;
        }
        if ((i & 2) != 0) {
            str2 = episode.thumbnail;
        }
        if ((i & 4) != 0) {
            str3 = episode.title;
        }
        if ((i & 8) != 0) {
            str4 = episode.duration;
        }
        if ((i & 16) != 0) {
            str5 = episode.released;
        }
        if ((i & 32) != 0) {
            l = episode.tmdb_fetch_episode;
        }
        if ((i & 64) != 0) {
            j = episode.id;
        }
        if ((i & 128) != 0) {
            str6 = episode.type;
        }
        if ((i & 256) != 0) {
            str7 = episode.url;
        }
        if ((i & 512) != 0) {
            str8 = episode.post_title;
        }
        if ((i & 1024) != 0) {
            str9 = episode.meta_number;
        }
        long j2 = j;
        String str10 = str5;
        Long l2 = l;
        String str11 = str3;
        String str12 = str4;
        return episode.copy(str, str2, str11, str12, str10, l2, j2, str6, str7, str8, str9);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNumber() {
        return this.number;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPost_title() {
        return this.post_title;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getMeta_number() {
        return this.meta_number;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getThumbnail() {
        return this.thumbnail;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getReleased() {
        return this.released;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getTmdb_fetch_episode() {
        return this.tmdb_fetch_episode;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final Episode copy(@NotNull String number, @NotNull String thumbnail, @NotNull String title, @NotNull String duration, @NotNull String released, @Nullable Long tmdb_fetch_episode, long id, @NotNull String type, @NotNull String url, @Nullable String post_title, @Nullable String meta_number) {
        return new Episode(number, thumbnail, title, duration, released, tmdb_fetch_episode, id, type, url, post_title, meta_number);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Episode)) {
            return false;
        }
        Episode episode = (Episode) other;
        return Intrinsics.areEqual(this.number, episode.number) && Intrinsics.areEqual(this.thumbnail, episode.thumbnail) && Intrinsics.areEqual(this.title, episode.title) && Intrinsics.areEqual(this.duration, episode.duration) && Intrinsics.areEqual(this.released, episode.released) && Intrinsics.areEqual(this.tmdb_fetch_episode, episode.tmdb_fetch_episode) && this.id == episode.id && Intrinsics.areEqual(this.type, episode.type) && Intrinsics.areEqual(this.url, episode.url) && Intrinsics.areEqual(this.post_title, episode.post_title) && Intrinsics.areEqual(this.meta_number, episode.meta_number);
    }

    public int hashCode() {
        return (((((((((((((((((((this.number.hashCode() * 31) + this.thumbnail.hashCode()) * 31) + this.title.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.released.hashCode()) * 31) + (this.tmdb_fetch_episode == null ? 0 : this.tmdb_fetch_episode.hashCode())) * 31) + Episode$$ExternalSyntheticBackport0.m13m(this.id)) * 31) + this.type.hashCode()) * 31) + this.url.hashCode()) * 31) + (this.post_title == null ? 0 : this.post_title.hashCode())) * 31) + (this.meta_number != null ? this.meta_number.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Episode(number=").append(this.number).append(", thumbnail=").append(this.thumbnail).append(", title=").append(this.title).append(", duration=").append(this.duration).append(", released=").append(this.released).append(", tmdb_fetch_episode=").append(this.tmdb_fetch_episode).append(", id=").append(this.id).append(", type=").append(this.type).append(", url=").append(this.url).append(", post_title=").append(this.post_title).append(", meta_number=").append(this.meta_number).append(')');
        return sb.toString();
    }

    public Episode(@NotNull String number, @NotNull String thumbnail, @NotNull String title, @NotNull String duration, @NotNull String released, @Nullable Long tmdb_fetch_episode, long id, @NotNull String type, @NotNull String url, @Nullable String post_title, @Nullable String meta_number) {
        this.number = number;
        this.thumbnail = thumbnail;
        this.title = title;
        this.duration = duration;
        this.released = released;
        this.tmdb_fetch_episode = tmdb_fetch_episode;
        this.id = id;
        this.type = type;
        this.url = url;
        this.post_title = post_title;
        this.meta_number = meta_number;
    }

    public /* synthetic */ Episode(String str, String str2, String str3, String str4, String str5, Long l, long j, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, (i & 32) != 0 ? null : l, j, str6, str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9);
    }

    @NotNull
    public final String getNumber() {
        return this.number;
    }

    @NotNull
    public final String getThumbnail() {
        return this.thumbnail;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getDuration() {
        return this.duration;
    }

    @NotNull
    public final String getReleased() {
        return this.released;
    }

    @Nullable
    public final Long getTmdb_fetch_episode() {
        return this.tmdb_fetch_episode;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final String getPost_title() {
        return this.post_title;
    }

    @Nullable
    public final String getMeta_number() {
        return this.meta_number;
    }
}
