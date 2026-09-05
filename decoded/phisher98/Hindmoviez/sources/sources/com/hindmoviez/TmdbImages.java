package com.hindmoviez;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Hindmoviez/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hindmoviez/TmdbImages;", "", "logos", "", "Lcom/hindmoviez/TmdbLogo;", "<init>", "(Ljava/util/List;)V", "getLogos", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Hindmoviez"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TmdbImages {

    @Nullable
    private final List<TmdbLogo> logos;

    /* JADX WARN: Illegal instructions before constructor call */
    public TmdbImages() {
        List list = null;
        this(list, 1, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TmdbImages copy$default(TmdbImages tmdbImages, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = tmdbImages.logos;
        }
        return tmdbImages.copy(list);
    }

    @Nullable
    public final List<TmdbLogo> component1() {
        return this.logos;
    }

    @NotNull
    public final TmdbImages copy(@Nullable List<TmdbLogo> logos) {
        return new TmdbImages(logos);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TmdbImages) && Intrinsics.areEqual(this.logos, ((TmdbImages) other).logos);
    }

    public int hashCode() {
        if (this.logos == null) {
            return 0;
        }
        return this.logos.hashCode();
    }

    @NotNull
    public String toString() {
        return "TmdbImages(logos=" + this.logos + ')';
    }

    public TmdbImages(@Nullable List<TmdbLogo> list) {
        this.logos = list;
    }

    public /* synthetic */ TmdbImages(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    @Nullable
    public final List<TmdbLogo> getLogos() {
        return this.logos;
    }
}
