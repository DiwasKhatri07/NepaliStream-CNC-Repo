package com.hindmoviez;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Hindmoviez/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/hindmoviez/TmdbLogo;", "", "file_path", "", "iso_639_1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFile_path", "()Ljava/lang/String;", "getIso_639_1", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Hindmoviez"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TmdbLogo {

    @Nullable
    private final String file_path;

    @Nullable
    private final String iso_639_1;

    /* JADX WARN: Illegal instructions before constructor call */
    public TmdbLogo() {
        String str = null;
        this(str, str, 3, str);
    }

    public static /* synthetic */ TmdbLogo copy$default(TmdbLogo tmdbLogo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tmdbLogo.file_path;
        }
        if ((i & 2) != 0) {
            str2 = tmdbLogo.iso_639_1;
        }
        return tmdbLogo.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFile_path() {
        return this.file_path;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIso_639_1() {
        return this.iso_639_1;
    }

    @NotNull
    public final TmdbLogo copy(@Nullable String file_path, @Nullable String iso_639_1) {
        return new TmdbLogo(file_path, iso_639_1);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TmdbLogo)) {
            return false;
        }
        TmdbLogo tmdbLogo = (TmdbLogo) other;
        return Intrinsics.areEqual(this.file_path, tmdbLogo.file_path) && Intrinsics.areEqual(this.iso_639_1, tmdbLogo.iso_639_1);
    }

    public int hashCode() {
        return ((this.file_path == null ? 0 : this.file_path.hashCode()) * 31) + (this.iso_639_1 != null ? this.iso_639_1.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TmdbLogo(file_path=" + this.file_path + ", iso_639_1=" + this.iso_639_1 + ')';
    }

    public TmdbLogo(@Nullable String file_path, @Nullable String iso_639_1) {
        this.file_path = file_path;
        this.iso_639_1 = iso_639_1;
    }

    public /* synthetic */ TmdbLogo(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    @Nullable
    public final String getFile_path() {
        return this.file_path;
    }

    @Nullable
    public final String getIso_639_1() {
        return this.iso_639_1;
    }
}
