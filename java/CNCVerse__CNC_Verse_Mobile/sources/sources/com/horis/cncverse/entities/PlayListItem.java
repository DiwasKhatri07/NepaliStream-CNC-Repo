package com.horis.cncverse.entities;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlayListItem.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/CNC_Verse_Mobile/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006 "}, d2 = {"Lcom/horis/cncverse/entities/PlayListItem;", "", "image", "", "image2", "sources", "", "Lcom/horis/cncverse/entities/Source;", "tracks", "Lcom/horis/cncverse/entities/Tracks;", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getImage", "()Ljava/lang/String;", "getImage2", "getSources", "()Ljava/util/List;", "getTracks", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "CNC Verse Mobile_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PlayListItem {

    @Nullable
    private final String image;

    @Nullable
    private final String image2;

    @NotNull
    private final List<Source> sources;

    @Nullable
    private final String title;

    @Nullable
    private final List<Tracks> tracks;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlayListItem copy$default(PlayListItem playListItem, String str, String str2, List list, List list2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playListItem.image;
        }
        if ((i & 2) != 0) {
            str2 = playListItem.image2;
        }
        if ((i & 4) != 0) {
            list = playListItem.sources;
        }
        if ((i & 8) != 0) {
            list2 = playListItem.tracks;
        }
        if ((i & 16) != 0) {
            str3 = playListItem.title;
        }
        String str4 = str3;
        List list3 = list;
        return playListItem.copy(str, str2, list3, list2, str4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getImage2() {
        return this.image2;
    }

    @NotNull
    public final List<Source> component3() {
        return this.sources;
    }

    @Nullable
    public final List<Tracks> component4() {
        return this.tracks;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final PlayListItem copy(@Nullable String image, @Nullable String image2, @NotNull List<Source> sources, @Nullable List<Tracks> tracks, @Nullable String title) {
        return new PlayListItem(image, image2, sources, tracks, title);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayListItem)) {
            return false;
        }
        PlayListItem playListItem = (PlayListItem) other;
        return Intrinsics.areEqual(this.image, playListItem.image) && Intrinsics.areEqual(this.image2, playListItem.image2) && Intrinsics.areEqual(this.sources, playListItem.sources) && Intrinsics.areEqual(this.tracks, playListItem.tracks) && Intrinsics.areEqual(this.title, playListItem.title);
    }

    public int hashCode() {
        return ((((((((this.image == null ? 0 : this.image.hashCode()) * 31) + (this.image2 == null ? 0 : this.image2.hashCode())) * 31) + this.sources.hashCode()) * 31) + (this.tracks == null ? 0 : this.tracks.hashCode())) * 31) + (this.title != null ? this.title.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PlayListItem(image=" + this.image + ", image2=" + this.image2 + ", sources=" + this.sources + ", tracks=" + this.tracks + ", title=" + this.title + ')';
    }

    public PlayListItem(@Nullable String image, @Nullable String image2, @NotNull List<Source> list, @Nullable List<Tracks> list2, @Nullable String title) {
        this.image = image;
        this.image2 = image2;
        this.sources = list;
        this.tracks = list2;
        this.title = title;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final String getImage2() {
        return this.image2;
    }

    @NotNull
    public final List<Source> getSources() {
        return this.sources;
    }

    @Nullable
    public final List<Tracks> getTracks() {
        return this.tracks;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }
}
