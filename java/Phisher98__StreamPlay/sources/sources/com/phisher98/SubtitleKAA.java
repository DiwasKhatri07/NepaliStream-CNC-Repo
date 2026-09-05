package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/SubtitleKAA;", "", "language", "", "name", "src", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "getName", "getSrc", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SubtitleKAA {

    @NotNull
    private final String language;

    @NotNull
    private final String name;

    @NotNull
    private final String src;

    public static /* synthetic */ SubtitleKAA copy$default(SubtitleKAA subtitleKAA, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subtitleKAA.language;
        }
        if ((i & 2) != 0) {
            str2 = subtitleKAA.name;
        }
        if ((i & 4) != 0) {
            str3 = subtitleKAA.src;
        }
        return subtitleKAA.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSrc() {
        return this.src;
    }

    @NotNull
    public final SubtitleKAA copy(@NotNull String language, @NotNull String name, @NotNull String src) {
        return new SubtitleKAA(language, name, src);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubtitleKAA)) {
            return false;
        }
        SubtitleKAA subtitleKAA = (SubtitleKAA) other;
        return Intrinsics.areEqual(this.language, subtitleKAA.language) && Intrinsics.areEqual(this.name, subtitleKAA.name) && Intrinsics.areEqual(this.src, subtitleKAA.src);
    }

    public int hashCode() {
        return (((this.language.hashCode() * 31) + this.name.hashCode()) * 31) + this.src.hashCode();
    }

    @NotNull
    public String toString() {
        return "SubtitleKAA(language=" + this.language + ", name=" + this.name + ", src=" + this.src + ')';
    }

    public SubtitleKAA(@NotNull String language, @NotNull String name, @NotNull String src) {
        this.language = language;
        this.name = name;
        this.src = src;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getSrc() {
        return this.src;
    }
}
