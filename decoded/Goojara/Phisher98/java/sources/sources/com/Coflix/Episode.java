package com.Coflix;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Goojara/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006!"}, d2 = {"Lcom/Coflix/Episode;", "", "id", "", "title", "", "number", "season", "links", "image", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "getNumber", "getSeason", "getLinks", "getImage", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Goojara"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Episode {
    private final long id;

    @NotNull
    private final String image;

    @NotNull
    private final String links;

    @NotNull
    private final String number;

    @NotNull
    private final String season;

    @NotNull
    private final String title;

    public static /* synthetic */ Episode copy$default(Episode episode, long j, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            j = episode.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = episode.title;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = episode.number;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = episode.season;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = episode.links;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = episode.image;
        }
        return episode.copy(j2, str6, str7, str8, str9, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNumber() {
        return this.number;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSeason() {
        return this.season;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLinks() {
        return this.links;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    @NotNull
    public final Episode copy(long id, @NotNull String title, @NotNull String number, @NotNull String season, @NotNull String links, @NotNull String image) {
        return new Episode(id, title, number, season, links, image);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Episode)) {
            return false;
        }
        Episode episode = (Episode) other;
        return this.id == episode.id && Intrinsics.areEqual(this.title, episode.title) && Intrinsics.areEqual(this.number, episode.number) && Intrinsics.areEqual(this.season, episode.season) && Intrinsics.areEqual(this.links, episode.links) && Intrinsics.areEqual(this.image, episode.image);
    }

    public int hashCode() {
        return (((((((((Episode$$ExternalSyntheticBackport0.m0m(this.id) * 31) + this.title.hashCode()) * 31) + this.number.hashCode()) * 31) + this.season.hashCode()) * 31) + this.links.hashCode()) * 31) + this.image.hashCode();
    }

    @NotNull
    public String toString() {
        return "Episode(id=" + this.id + ", title=" + this.title + ", number=" + this.number + ", season=" + this.season + ", links=" + this.links + ", image=" + this.image + ')';
    }

    public Episode(long id, @NotNull String title, @NotNull String number, @NotNull String season, @NotNull String links, @NotNull String image) {
        this.id = id;
        this.title = title;
        this.number = number;
        this.season = season;
        this.links = links;
        this.image = image;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getNumber() {
        return this.number;
    }

    @NotNull
    public final String getSeason() {
        return this.season;
    }

    @NotNull
    public final String getLinks() {
        return this.links;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }
}
