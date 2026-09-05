package com.anineko;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AninekoUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Anineko/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/anineko/AniListMedia;", "", "id", "", "<init>", "(Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/anineko/AniListMedia;", "equals", "", "other", "hashCode", "toString", "", "Anineko"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AniListMedia {

    @Nullable
    private final Integer id;

    /* JADX WARN: Illegal instructions before constructor call */
    public AniListMedia() {
        Integer num = null;
        this(num, 1, num);
    }

    public static /* synthetic */ AniListMedia copy$default(AniListMedia aniListMedia, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = aniListMedia.id;
        }
        return aniListMedia.copy(num);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @NotNull
    public final AniListMedia copy(@Nullable Integer id) {
        return new AniListMedia(id);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AniListMedia) && Intrinsics.areEqual(this.id, ((AniListMedia) other).id);
    }

    public int hashCode() {
        if (this.id == null) {
            return 0;
        }
        return this.id.hashCode();
    }

    @NotNull
    public String toString() {
        return "AniListMedia(id=" + this.id + ')';
    }

    public AniListMedia(@Nullable Integer id) {
        this.id = id;
    }

    public /* synthetic */ AniListMedia(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num);
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }
}
