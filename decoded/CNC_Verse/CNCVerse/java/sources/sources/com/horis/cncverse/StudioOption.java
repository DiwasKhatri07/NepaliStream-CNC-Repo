package com.horis.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CNCVerseSettings.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CNC_Verse/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/horis/cncverse/StudioOption;", "", "key", "", "label", "cookieValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getLabel", "getCookieValue", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "CNC Verse_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class StudioOption {

    @NotNull
    private final String cookieValue;

    @NotNull
    private final String key;

    @NotNull
    private final String label;

    public static /* synthetic */ StudioOption copy$default(StudioOption studioOption, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = studioOption.key;
        }
        if ((i & 2) != 0) {
            str2 = studioOption.label;
        }
        if ((i & 4) != 0) {
            str3 = studioOption.cookieValue;
        }
        return studioOption.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCookieValue() {
        return this.cookieValue;
    }

    @NotNull
    public final StudioOption copy(@NotNull String key, @NotNull String label, @NotNull String cookieValue) {
        return new StudioOption(key, label, cookieValue);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StudioOption)) {
            return false;
        }
        StudioOption studioOption = (StudioOption) other;
        return Intrinsics.areEqual(this.key, studioOption.key) && Intrinsics.areEqual(this.label, studioOption.label) && Intrinsics.areEqual(this.cookieValue, studioOption.cookieValue);
    }

    public int hashCode() {
        return (((this.key.hashCode() * 31) + this.label.hashCode()) * 31) + this.cookieValue.hashCode();
    }

    @NotNull
    public String toString() {
        return "StudioOption(key=" + this.key + ", label=" + this.label + ", cookieValue=" + this.cookieValue + ')';
    }

    public StudioOption(@NotNull String key, @NotNull String label, @NotNull String cookieValue) {
        this.key = key;
        this.label = label;
        this.cookieValue = cookieValue;
    }

    @NotNull
    public final String getCookieValue() {
        return this.cookieValue;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }
}
