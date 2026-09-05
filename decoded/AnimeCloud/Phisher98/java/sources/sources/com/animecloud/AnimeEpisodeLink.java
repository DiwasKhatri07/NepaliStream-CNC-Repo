package com.animecloud;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AnimeCloud/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003JV\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006'"}, d2 = {"Lcom/animecloud/AnimeEpisodeLink;", "", "id", "", "createdAt", "", "updatedAt", "link", "lang", "animeEpisodeId", "name", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getId", "()J", "getCreatedAt", "()Ljava/lang/String;", "getUpdatedAt", "getLink", "getLang", "getAnimeEpisodeId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/animecloud/AnimeEpisodeLink;", "equals", "", "other", "hashCode", "", "toString", "AnimeCloud"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnimeEpisodeLink {

    @Nullable
    private final Long animeEpisodeId;

    @NotNull
    private final String createdAt;
    private final long id;

    @NotNull
    private final String lang;

    @NotNull
    private final String link;

    @NotNull
    private final String name;

    @NotNull
    private final String updatedAt;

    public static /* synthetic */ AnimeEpisodeLink copy$default(AnimeEpisodeLink animeEpisodeLink, long j, String str, String str2, String str3, String str4, Long l, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            j = animeEpisodeLink.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = animeEpisodeLink.createdAt;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = animeEpisodeLink.updatedAt;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = animeEpisodeLink.link;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = animeEpisodeLink.lang;
        }
        return animeEpisodeLink.copy(j2, str6, str7, str8, str4, (i & 32) != 0 ? animeEpisodeLink.animeEpisodeId : l, (i & 64) != 0 ? animeEpisodeLink.name : str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getAnimeEpisodeId() {
        return this.animeEpisodeId;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final AnimeEpisodeLink copy(long id, @NotNull String createdAt, @NotNull String updatedAt, @NotNull String link, @NotNull String lang, @Nullable Long animeEpisodeId, @NotNull String name) {
        return new AnimeEpisodeLink(id, createdAt, updatedAt, link, lang, animeEpisodeId, name);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimeEpisodeLink)) {
            return false;
        }
        AnimeEpisodeLink animeEpisodeLink = (AnimeEpisodeLink) other;
        return this.id == animeEpisodeLink.id && Intrinsics.areEqual(this.createdAt, animeEpisodeLink.createdAt) && Intrinsics.areEqual(this.updatedAt, animeEpisodeLink.updatedAt) && Intrinsics.areEqual(this.link, animeEpisodeLink.link) && Intrinsics.areEqual(this.lang, animeEpisodeLink.lang) && Intrinsics.areEqual(this.animeEpisodeId, animeEpisodeLink.animeEpisodeId) && Intrinsics.areEqual(this.name, animeEpisodeLink.name);
    }

    public int hashCode() {
        return (((((((((((AnimeEpisodeLink$$ExternalSyntheticBackport0.m1m(this.id) * 31) + this.createdAt.hashCode()) * 31) + this.updatedAt.hashCode()) * 31) + this.link.hashCode()) * 31) + this.lang.hashCode()) * 31) + (this.animeEpisodeId == null ? 0 : this.animeEpisodeId.hashCode())) * 31) + this.name.hashCode();
    }

    @NotNull
    public String toString() {
        return "AnimeEpisodeLink(id=" + this.id + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", link=" + this.link + ", lang=" + this.lang + ", animeEpisodeId=" + this.animeEpisodeId + ", name=" + this.name + ')';
    }

    public AnimeEpisodeLink(long id, @NotNull String createdAt, @NotNull String updatedAt, @NotNull String link, @NotNull String lang, @Nullable Long animeEpisodeId, @NotNull String name) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.link = link;
        this.lang = lang;
        this.animeEpisodeId = animeEpisodeId;
        this.name = name;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @NotNull
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    @NotNull
    public final String getLink() {
        return this.link;
    }

    @NotNull
    public final String getLang() {
        return this.lang;
    }

    @Nullable
    public final Long getAnimeEpisodeId() {
        return this.animeEpisodeId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }
}
