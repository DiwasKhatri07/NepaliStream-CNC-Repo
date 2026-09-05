package com.idlix;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IdlixProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IdlixProvider/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/idlix/Subtitle;", "", "lang", "", "label", "path", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLang", "()Ljava/lang/String;", "getLabel", "getPath", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "IdlixProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Subtitle {

    @NotNull
    private final String label;

    @NotNull
    private final String lang;

    @NotNull
    private final String path;

    public static /* synthetic */ Subtitle copy$default(Subtitle subtitle, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subtitle.lang;
        }
        if ((i & 2) != 0) {
            str2 = subtitle.label;
        }
        if ((i & 4) != 0) {
            str3 = subtitle.path;
        }
        return subtitle.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final Subtitle copy(@NotNull String lang, @NotNull String label, @NotNull String path) {
        return new Subtitle(lang, label, path);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Subtitle)) {
            return false;
        }
        Subtitle subtitle = (Subtitle) other;
        return Intrinsics.areEqual(this.lang, subtitle.lang) && Intrinsics.areEqual(this.label, subtitle.label) && Intrinsics.areEqual(this.path, subtitle.path);
    }

    public int hashCode() {
        return (((this.lang.hashCode() * 31) + this.label.hashCode()) * 31) + this.path.hashCode();
    }

    @NotNull
    public String toString() {
        return "Subtitle(lang=" + this.lang + ", label=" + this.label + ", path=" + this.path + ')';
    }

    public Subtitle(@NotNull String lang, @NotNull String label, @NotNull String path) {
        this.lang = lang;
        this.label = label;
        this.path = path;
    }

    @NotNull
    public final String getLang() {
        return this.lang;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }
}
