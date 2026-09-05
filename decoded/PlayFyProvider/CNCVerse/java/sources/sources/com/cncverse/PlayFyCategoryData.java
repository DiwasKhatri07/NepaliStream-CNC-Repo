package com.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlayFyProviderManager.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/PlayFyProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/cncverse/PlayFyCategoryData;", "", "id", "", "title", "image", "catLink", "position", "publish", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "getImage", "getCatLink", "getPosition", "getPublish", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "PlayFyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PlayFyCategoryData {

    @Nullable
    private final String catLink;

    @Nullable
    private final String id;

    @Nullable
    private final String image;

    @Nullable
    private final String position;

    @Nullable
    private final String publish;

    @Nullable
    private final String title;

    public static /* synthetic */ PlayFyCategoryData copy$default(PlayFyCategoryData playFyCategoryData, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playFyCategoryData.id;
        }
        if ((i & 2) != 0) {
            str2 = playFyCategoryData.title;
        }
        if ((i & 4) != 0) {
            str3 = playFyCategoryData.image;
        }
        if ((i & 8) != 0) {
            str4 = playFyCategoryData.catLink;
        }
        if ((i & 16) != 0) {
            str5 = playFyCategoryData.position;
        }
        if ((i & 32) != 0) {
            str6 = playFyCategoryData.publish;
        }
        String str7 = str5;
        String str8 = str6;
        return playFyCategoryData.copy(str, str2, str3, str4, str7, str8);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCatLink() {
        return this.catLink;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPosition() {
        return this.position;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPublish() {
        return this.publish;
    }

    @NotNull
    public final PlayFyCategoryData copy(@Nullable String id, @Nullable String title, @Nullable String image, @Nullable String catLink, @Nullable String position, @Nullable String publish) {
        return new PlayFyCategoryData(id, title, image, catLink, position, publish);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayFyCategoryData)) {
            return false;
        }
        PlayFyCategoryData playFyCategoryData = (PlayFyCategoryData) other;
        return Intrinsics.areEqual(this.id, playFyCategoryData.id) && Intrinsics.areEqual(this.title, playFyCategoryData.title) && Intrinsics.areEqual(this.image, playFyCategoryData.image) && Intrinsics.areEqual(this.catLink, playFyCategoryData.catLink) && Intrinsics.areEqual(this.position, playFyCategoryData.position) && Intrinsics.areEqual(this.publish, playFyCategoryData.publish);
    }

    public int hashCode() {
        return ((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.catLink == null ? 0 : this.catLink.hashCode())) * 31) + (this.position == null ? 0 : this.position.hashCode())) * 31) + (this.publish != null ? this.publish.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PlayFyCategoryData(id=" + this.id + ", title=" + this.title + ", image=" + this.image + ", catLink=" + this.catLink + ", position=" + this.position + ", publish=" + this.publish + ')';
    }

    public PlayFyCategoryData(@Nullable String id, @Nullable String title, @Nullable String image, @Nullable String catLink, @Nullable String position, @Nullable String publish) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.catLink = catLink;
        this.position = position;
        this.publish = publish;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final String getCatLink() {
        return this.catLink;
    }

    @Nullable
    public final String getPosition() {
        return this.position;
    }

    @Nullable
    public final String getPublish() {
        return this.publish;
    }
}
