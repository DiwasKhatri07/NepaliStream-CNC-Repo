package com.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlayZTVProviderManager.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/PlayZTVProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/cncverse/PlayZTVProviderEntry;", "", "id", "", "title", "", "image", "catLink", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getImage", "getCatLink", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "PlayZTVProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PlayZTVProviderEntry {

    @Nullable
    private final String catLink;
    private final int id;

    @NotNull
    private final String image;

    @NotNull
    private final String title;

    public static /* synthetic */ PlayZTVProviderEntry copy$default(PlayZTVProviderEntry playZTVProviderEntry, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = playZTVProviderEntry.id;
        }
        if ((i2 & 2) != 0) {
            str = playZTVProviderEntry.title;
        }
        if ((i2 & 4) != 0) {
            str2 = playZTVProviderEntry.image;
        }
        if ((i2 & 8) != 0) {
            str3 = playZTVProviderEntry.catLink;
        }
        return playZTVProviderEntry.copy(i, str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCatLink() {
        return this.catLink;
    }

    @NotNull
    public final PlayZTVProviderEntry copy(int id, @NotNull String title, @NotNull String image, @Nullable String catLink) {
        return new PlayZTVProviderEntry(id, title, image, catLink);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayZTVProviderEntry)) {
            return false;
        }
        PlayZTVProviderEntry playZTVProviderEntry = (PlayZTVProviderEntry) other;
        return this.id == playZTVProviderEntry.id && Intrinsics.areEqual(this.title, playZTVProviderEntry.title) && Intrinsics.areEqual(this.image, playZTVProviderEntry.image) && Intrinsics.areEqual(this.catLink, playZTVProviderEntry.catLink);
    }

    public int hashCode() {
        return (((((this.id * 31) + this.title.hashCode()) * 31) + this.image.hashCode()) * 31) + (this.catLink == null ? 0 : this.catLink.hashCode());
    }

    @NotNull
    public String toString() {
        return "PlayZTVProviderEntry(id=" + this.id + ", title=" + this.title + ", image=" + this.image + ", catLink=" + this.catLink + ')';
    }

    public PlayZTVProviderEntry(int id, @NotNull String title, @NotNull String image, @Nullable String catLink) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.catLink = catLink;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final String getCatLink() {
        return this.catLink;
    }
}
