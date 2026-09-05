package com.anineko;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AninekoUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Anineko/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/anineko/AniListData;", "", "media", "Lcom/anineko/AniListMedia;", "<init>", "(Lcom/anineko/AniListMedia;)V", "getMedia", "()Lcom/anineko/AniListMedia;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anineko"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AniListData {

    @Nullable
    private final AniListMedia media;

    /* JADX WARN: Illegal instructions before constructor call */
    public AniListData() {
        AniListMedia aniListMedia = null;
        this(aniListMedia, 1, aniListMedia);
    }

    public static /* synthetic */ AniListData copy$default(AniListData aniListData, AniListMedia aniListMedia, int i, Object obj) {
        if ((i & 1) != 0) {
            aniListMedia = aniListData.media;
        }
        return aniListData.copy(aniListMedia);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AniListMedia getMedia() {
        return this.media;
    }

    @NotNull
    public final AniListData copy(@Nullable AniListMedia media) {
        return new AniListData(media);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AniListData) && Intrinsics.areEqual(this.media, ((AniListData) other).media);
    }

    public int hashCode() {
        if (this.media == null) {
            return 0;
        }
        return this.media.hashCode();
    }

    @NotNull
    public String toString() {
        return "AniListData(media=" + this.media + ')';
    }

    public AniListData(@Nullable AniListMedia media) {
        this.media = media;
    }

    public /* synthetic */ AniListData(AniListMedia aniListMedia, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : aniListMedia);
    }

    @Nullable
    public final AniListMedia getMedia() {
        return this.media;
    }
}
