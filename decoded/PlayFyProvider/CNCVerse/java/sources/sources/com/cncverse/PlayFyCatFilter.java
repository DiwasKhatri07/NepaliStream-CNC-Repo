package com.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlayFyProviderManager.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/PlayFyProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/cncverse/PlayFyCatFilter;", "", "id", "", "title", "image", "position", "publish", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "getImage", "getPosition", "getPublish", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "PlayFyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PlayFyCatFilter {

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

    public static /* synthetic */ PlayFyCatFilter copy$default(PlayFyCatFilter playFyCatFilter, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playFyCatFilter.id;
        }
        if ((i & 2) != 0) {
            str2 = playFyCatFilter.title;
        }
        if ((i & 4) != 0) {
            str3 = playFyCatFilter.image;
        }
        if ((i & 8) != 0) {
            str4 = playFyCatFilter.position;
        }
        if ((i & 16) != 0) {
            str5 = playFyCatFilter.publish;
        }
        String str6 = str5;
        String str7 = str3;
        return playFyCatFilter.copy(str, str2, str7, str4, str6);
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
    public final String getPosition() {
        return this.position;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPublish() {
        return this.publish;
    }

    @NotNull
    public final PlayFyCatFilter copy(@Nullable String id, @Nullable String title, @Nullable String image, @Nullable String position, @Nullable String publish) {
        return new PlayFyCatFilter(id, title, image, position, publish);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayFyCatFilter)) {
            return false;
        }
        PlayFyCatFilter playFyCatFilter = (PlayFyCatFilter) other;
        return Intrinsics.areEqual(this.id, playFyCatFilter.id) && Intrinsics.areEqual(this.title, playFyCatFilter.title) && Intrinsics.areEqual(this.image, playFyCatFilter.image) && Intrinsics.areEqual(this.position, playFyCatFilter.position) && Intrinsics.areEqual(this.publish, playFyCatFilter.publish);
    }

    public int hashCode() {
        return ((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.position == null ? 0 : this.position.hashCode())) * 31) + (this.publish != null ? this.publish.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PlayFyCatFilter(id=" + this.id + ", title=" + this.title + ", image=" + this.image + ", position=" + this.position + ", publish=" + this.publish + ')';
    }

    public PlayFyCatFilter(@Nullable String id, @Nullable String title, @Nullable String image, @Nullable String position, @Nullable String publish) {
        this.id = id;
        this.title = title;
        this.image = image;
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
    public final String getPosition() {
        return this.position;
    }

    @Nullable
    public final String getPublish() {
        return this.publish;
    }
}
